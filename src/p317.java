import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Larry Liu on 11/19/2017.
 * 317. Shortest Distance from All Buildings
 */
public class p317 {
    public int shortestDistance(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] distances = new int[M][N];
        int minDist = -1;
        List<Queue<int[]>> listQueue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    listQueue.add(q);
                }
            }
        }
        int buildings = listQueue.size();
        int walk = 0;
        int[][] incs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        // bfs

        for (int i = 0; i < buildings; i++) {
            int step = 1;
            minDist = Integer.MAX_VALUE;
            Queue<int[]> curr = listQueue.get(i);
            while (!curr.isEmpty()) {
                Queue<int[]> temp = new LinkedList<>();
                while (!curr.isEmpty()) {
                    int[] pos = curr.poll();
                    for (int[] inc : incs) {
                        int[] next = new int[]{pos[0]+inc[0], pos[1]+inc[1]};
                        if (isValid(grid, walk, next[0], next[1])) {
                            grid[next[0]][next[1]]--;
                            distances[next[0]][next[1]] += step;
                            minDist = Math.min(minDist, distances[next[0]][next[1]]);
                            temp.offer(next);
                        }
                    }
                }
                step++;
                curr = temp;
            }
            walk--;
        }

        return minDist == Integer.MAX_VALUE? -1: minDist;
    }

    private boolean isValid(int[][] grid, int walk, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return false;
        return grid[row][col] == walk;
    }

    public static void main(String[] args) {
        p317 sol = new p317();
        System.out.println(sol.shortestDistance(new int[][]{
                {1,1,1,1,1,1,1,0},
                {0,0,0,0,0,0,0,1},
                {0,1,1,1,1,0,0,1},
                {1,0,0,0,0,1,0,1},
                {1,0,0,1,0,1,0,1},
                {1,0,1,0,0,1,0,1},
                {1,0,0,1,1,0,0,1},
                {1,0,0,0,0,0,0,1},
                {0,1,1,1,1,1,1,0}}));
    }


}
