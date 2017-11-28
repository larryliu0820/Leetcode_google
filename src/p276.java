/**
 * Created by mengwliu on 11/27/17
 * 276. Paint Fence
 */
public class p276 {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        int dp_0 = k, dp_1 = 0;
        for (int i = 1; i < n; i++) {
            int temp = dp_0;
            dp_0 = dp_0 * (k-1) + dp_1 * (k-1);
            dp_1 = temp;
        }
        return dp_0 + dp_1;
    }
}
