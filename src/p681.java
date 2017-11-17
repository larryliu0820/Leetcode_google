import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by mengwliu on 11/16/17.
 * 681. Next Closest Time
 */
public class p681 {
    String original;
    String res = "";
    int diff;
    public String nextClosestTime(String time) {
        original = time.substring(0,2)+time.substring(3);
        Set<Integer> set = new HashSet<>();
        for (char c: time.toCharArray()) if (c != ':') set.add(c-'0');
        backtrack("", new LinkedList<>(set));
        return res.substring(0, 2) + ":" + res.substring(2);
    }

    private void backtrack(String curr, List<Integer> nums) {
        if (curr.length() == 4) {
            if (res.length() == 0) {
                res = curr;
                diff = diff(original, res);
            } else if (!curr.equals(original)){
                int currDiff = diff(original, curr);
                if (currDiff < diff) {
                    res = curr;
                    diff = currDiff;
                }
            }
            return;
        }
        int index = curr.length();
        for (int i = 0; i < nums.size(); i++) {
            if (index == 0) {
                if (nums.get(i) > 2) continue;
            } else if (index == 1) {
                if (nums.get(i) + (curr.charAt(0)-'0') * 10 > 23) continue;
            } else if (index == 2) {
                if (nums.get(i) > 5) continue;
            } else if (index == 3) {
                if (nums.get(i) + (curr.charAt(2)-'0') * 10 > 59) continue;
            }
            backtrack(curr + nums.get(i), nums);
        }
    }

    private int diff(String time1, String time2) {
        int val1 = Integer.parseInt(time1.substring(0, 2)) * 60 + Integer.parseInt(time1.substring(2, 4));
        int val2 = Integer.parseInt(time2.substring(0, 2)) * 60 + Integer.parseInt(time2.substring(2, 4));
        if (val2 < val1) return 24 * 60 + val2 - val1;
        else return val2 - val1;
    }

    public static void main(String[] args) {
        p681 sol = new p681();
        System.out.println(sol.nextClosestTime("19:34"));
    }
}
