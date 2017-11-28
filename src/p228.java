import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengwliu on 11/25/17
 * 228. Summary Ranges
 */
public class p228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1] + 1) {
                if (end == start) {
                    res.add(""+start);
                } else {
                    res.add(start + "->" + end);
                }
                start = nums[i];
            }
            end = nums[i];
        }

        if (end == start) {
            res.add(""+start);
        } else {
            res.add(start + "->" + end);
        }
        return res;
    }
}
