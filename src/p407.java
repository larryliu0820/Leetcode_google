import java.util.PriorityQueue;

/**
 * Created by mengwliu on 11/25/17
 */
public class p407 {
    class Block {
        int x, y;
        int h;
        Block(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    int M, N;
    public int trapRainWater(int[][] heightMap) {
        M = heightMap.length;
        N = heightMap[0].length;
        boolean[][] visited = new boolean[M][N];
        PriorityQueue<Block> pq = new PriorityQueue<>((a, b)->a.h-b.h);
        for (int i = 0; i < M; i++) {
            visited[i][0] = true;
            visited[i][N-1] = true;
            pq.offer(new Block(i, 0, heightMap[i][0]));
            pq.offer(new Block(i, N-1, heightMap[i][N-1]));
        }

        for (int i = 1; i < N-1; i++) {
            visited[0][i] = true;
            visited[M-1][i] = true;
            pq.offer(new Block(0, i, heightMap[0][i]));
            pq.offer(new Block(M-1, i, heightMap[M-1][i]));
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int res = 0;
        while (!pq.isEmpty()) {
            Block curr = pq.poll();
            for (int[] dir: dirs) {
                int x = curr.x + dir[0];
                int y = curr.y + dir[1];
                if (x >= 0 && x < M && y >= 0 && y < N && !visited[x][y]) {
                    visited[x][y] = true;
                    res += Math.max(0, curr.h - heightMap[x][y]);
                    pq.offer(new Block(x, y, Math.max(curr.h, heightMap[x][y])));
                }
            }
        }
        return res;
    }
}
