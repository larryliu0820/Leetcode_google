import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengwliu on 11/26/17
 * 294. Flip Game II
 */
public class p294 {
    public boolean canWin(String s) {
        Map<String, Boolean> memo = new HashMap<>();
        return helper(memo, s);
    }

    private boolean helper(Map<String, Boolean> memo, String s) {
        if (!memo.containsKey(s)) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.startsWith("++", i)) {
                    String flipped = s.substring(0, i) + "--" + s.substring(i+2);
                    if (!helper(memo, flipped)) {
                        memo.put(s, true);
                        return true;
                    }
                }
            }
            memo.put(s, false);
        }
        return memo.get(s);
    }
}
