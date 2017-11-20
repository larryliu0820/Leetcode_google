import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Larry Liu on 11/18/2017.
 * 568. Maximum Vacation Days
 */
public class p568 {
    int max = 0;
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < K; i++) {
            int[] temp = new int[N];
            Arrays.fill(temp, Integer.MIN_VALUE);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (j == k || flights[k][j] == 1) {
                        temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                    }
                }
            }
            dp = temp;
        }
        int max = 0;
        for (int i : dp) if (max < i) max = i;
        return max;
    }

    private void dfs(int[][] flights, int[][] days, int city, int week, int currSum) {
        if (week == days[0].length) {
            if (max < currSum) max = currSum;
            return;
        }
        int[] currFlights = flights[city];
        for (int i = 0; i < currFlights.length; i++) {
            if (currFlights[i] == 1 || i == city) {
                dfs(flights, days, i, week + 1, currSum + days[i][week]);
            }
        }
    }
}
