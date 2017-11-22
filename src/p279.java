import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry Liu on 11/21/2017.
 * 279. Perfect Squares
 */
public class p279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j*j >= 0) {
                min = Math.min(min, dp[i-j*j] + 1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
