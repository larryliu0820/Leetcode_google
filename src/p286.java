import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengwliu on 11/26/17
 * 286. Walls and Gates
 */
public class p286 {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int M = rooms.length, N = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir: dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                if (row >= 0 && row < M && col >= 0 && col < N && rooms[row][col] == Integer.MAX_VALUE) {
                    rooms[row][col] = rooms[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{row, col});
                }
            }
        }
    }
}
