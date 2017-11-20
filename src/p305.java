import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 11/19/2017.
 * 305. Number of Islands II
 */
public class p305 {
    class UF {
        int[] father;
        int[] sizes;
        UF(int size) {
            father = new int[size];
            sizes = new int[size];
            for (int i = 0; i < father.length; i++) {
                father[i] = -1;
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

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UF uf = new UF(m * n);
        int[][] incs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        List<Integer> res = new LinkedList<>();
        int count = 0;
        for (int[] pos: positions) {
            int ind = pos[0] * n + pos[1];
            uf.father[ind] = ind;
            count++;
            for (int[] inc: incs) {
                int x = pos[0] + inc[0];
                int y = pos[1] + inc[1];
                int newInd = x * n + y;
                if (x < 0 || x >= m || y < 0 || y >= n || uf.father[newInd] == -1) continue;
                int newFather = uf.find(newInd);
                if (ind != newFather) {
                    uf.connect(ind, newInd);
                    ind = uf.find(ind);
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
}
