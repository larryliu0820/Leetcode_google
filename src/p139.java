import java.util.List;

/**
 * Created by Larry Liu on 11/16/2017.
 * 139. Word Break
 */
public class p139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() <= i &&
                        dp[i-word.length()] &&
                        s.substring(i-word.length(), i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
