/**
 * Created by mengwliu on 11/27/17
 * 463. Island Perimeter
 */
public class p463 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0, M = grid.length, N = grid[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    res += 2;
                    if (i > 0 && grid[i - 1][j] == 1) res--;
                    else res++;
                    if (j > 0 && grid[i][j-1] == 1) res--;
                    else res++;
                }
            }
        }
        return res;
    }
}
