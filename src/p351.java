import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Larry Liu on 11/19/2017.
 * 351. Android Unlock Patterns
 */
public class p351 {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[3][7] = skip[2][8] = skip[4][6] = 5;
        skip[9][1] = skip[7][3] = skip[8][2] = skip[6][4] = 5;
        boolean[] visited = new boolean[10];
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += dfs(visited, skip, 1, i-1) * 4;
            res += dfs(visited, skip, 2, i-1) * 4;
            res += dfs(visited, skip, 5, i-1);
        }
        return res;
    }

    private int dfs(boolean[] visited, int[][] skip, int curr, int remain) {
        if (remain == 0) return 1;
        visited[curr] = true;
        int res = 0;
        for (int i = 1; i < 10; i++) {
            if (!visited[i] && (skip[curr][i] == 0 || visited[skip[curr][i]])) {
                res += dfs(visited, skip, i, remain-1);
            }
        }
        visited[curr] = false;
        return res;
    }

    public static void main(String[] args) {
        p351 sol = new p351();
        System.out.println(sol.numberOfPatterns(1, 3));
    }
}
