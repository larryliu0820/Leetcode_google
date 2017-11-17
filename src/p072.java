/**
 * Created by Larry Liu on 11/16/2017.
 * 72. Edit Distance
 */
public class p072 {
    public int minDistance(String word1, String word2) {
        int M = word1.length(), N = word2.length();
        int[][] dp = new int[M+1][N+1];
        for (int i = 0; i < M; i++) dp[i+1][0] = i;
        for (int i = 0; i < N; i++) dp[0][i+1] = i;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (word1.charAt(i) == word2.charAt(j)) dp[i+1][j+1] = dp[i][j];
                else {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]);
                }
            }
        }
        return dp[M][N];
    }
}
