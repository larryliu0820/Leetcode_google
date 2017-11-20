/**
 * Created by Larry Liu on 11/18/2017.
 * 361. Bomb Enemy
 */
public class p361 {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int result = 0, rowhits = 0;
        int[] colhits = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j-1] == 'W') {
                    rowhits = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        rowhits += grid[i][k] == 'E'?1: 0;
                    }
                }
                if (i == 0 || grid[i-1][j] == 'W') {
                    colhits[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        colhits[j] += grid[k][j] == 'E' ? 1:0;
                    }
                }
                if (grid[i][j] == '0') result = Math.max(result, rowhits + colhits[j]);
            }
        }
        return result;
    }
}
