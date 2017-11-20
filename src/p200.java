/**
 * Created by Larry Liu on 11/19/2017.
 */
public class p200 {
    class UF {
        int[] father;
        int[] sizes;
        UF(int size) {
            father = new int[size];
            sizes = new int[size];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
                sizes[i] = 1;
            }
        }

        int find(int i) {
            while (father[i] != i) {
                father[i] = father[father[i]];
                i = father[i];
            }
            return i;
        }

        void connect(int i, int j) {
            int rootA = find(i);
            int rootB = find(j);
            if (rootA == rootB) return;
            if (sizes[rootA] < sizes[rootB]) {
                father[rootA] = rootB;
                sizes[rootB] += sizes[rootA];
            } else {
                father[rootB] = rootA;
                sizes[rootA] += sizes[rootB];
            }
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int M = grid.length, N = grid[0].length;
        UF uf = new UF(M * N);
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '0') continue;
                count++;
                int index = i * N + j;
                if (i > 0 && grid[i-1][j] == '1') {
                    if (uf.find(index-N) != uf.find(index)) {
                        uf.connect(index-N, index);
                        count--;
                    }
                }
                if (j > 0 && grid[i][j-1] == '1') {
                    if (uf.find(index-1) != uf.find(index)) {
                        uf.connect(index-1, index);
                        count--;
                    }
                }
            }
        }
        return count;
    }
}
