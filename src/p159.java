/**
 * Created by Larry Liu on 11/20/2017.
 * 159. Longest Substring with At Most Two Distinct Characters
 */
public class p159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0;
        int[] map = new int[128];
        int count = 0;
        int maxLen = 0;
        while (right < s.length()) {
            if (map[s.charAt(right++)]++ == 0) {
                count++;
            }
            while (count > 2) {
                if (--map[s.charAt(left++)] == 0) {
                    count--;
                }
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
