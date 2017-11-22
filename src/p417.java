import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Larry Liu on 11/21/2017.
 * 417. Pacific Atlantic Water Flow
 */
public class p417 {
    int[][] matrix;
    int M, N;
    List<int[]> res;
    int[][] dirs;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        this.matrix = matrix;

        res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        M = matrix.length;
        N = matrix[0].length;
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] pVisited = new boolean[M][N];
        boolean[][] aVisited = new boolean[M][N];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, N-1});
            pVisited[i][0] = true;
            aVisited[i][N-1] = true;
        }

        for (int j = 0; j < N; j++) {
            pQueue.offer(new int[]{0, j});
            aQueue.offer(new int[]{M-1, j});
            pVisited[0][j] = true;
            aVisited[M-1][j] = true;
        }
        bfs(pQueue, pVisited);
        bfs(aQueue, aVisited);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (aVisited[i][j] && pVisited[i][j]) res.add(new int[]{i, j});
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir: dirs) {
                int nrow = curr[0]+dir[0];
                int ncol = curr[1]+dir[1];
                if (isValid(visited, nrow, ncol) && matrix[curr[0]][curr[1]] <= matrix[nrow][ncol]) {
                    visited[nrow][ncol] = true;
                    queue.offer(new int[]{nrow, ncol});
                }
            }
        }
    }
    private boolean isValid(boolean[][] visited, int row, int col) {
        return !(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col]);
    }
}
