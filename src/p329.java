import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Larry Liu on 11/20/2017.
 * 329. Longest Increasing Path in a Matrix
 */
public class p329 {
    Map<Integer, Integer> map;
    int[][] matrix;
    int M, N;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        map = new HashMap<>();
        this.matrix = matrix;
        M = matrix.length;
        N = matrix[0].length;
        int maxLen = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                maxLen = Math.max(maxLen, dfs(i, j));
            }
        }
        return maxLen;
    }

    private int dfs(int row, int col) {
        if (!map.containsKey(row * N + col)) {
            int len = 0;
            for (int[] dir: dirs) {
                int nrow = row + dir[0], ncol = col + dir[1];
                if (isValid(nrow, ncol) && matrix[nrow][ncol] > matrix[row][col]) {
                    len = Math.max(len, dfs(nrow, ncol));
                }
            }
            map.put(row * N + col, len + 1);
        }
        return map.get(row * N + col);
    }

    private boolean isValid(int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return false;
        return true;
    }
}
