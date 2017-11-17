/**
 * Created by mengwliu on 11/16/17.
 * 340. Longest Substring with At Most K Distinct Characters
 *  Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.
 */
public class p340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() <= k) return s.length();
        int count = 0, maxLen = 0;
        int left = 0, right = 0;
        int[] map = new int[128];
        while (right < s.length()) {
            if (map[s.charAt(right++)]++ == 0) {
                count++;
            }
            while (count > k) {
                if (--map[s.charAt(left++)] == 0) {
                    count--;
                }
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        p340 sol = new p340();
        sol.lengthOfLongestSubstringKDistinct("nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy", 25);
    }
}
