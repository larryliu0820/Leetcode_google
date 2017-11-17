/**
 * Created by mengwliu on 11/16/17.
 * 308. Range Sum Query 2D - Mutable
 */
public class p308 {
    int M;
    int N;
    int[][] tree;
    int[][] matrix;
    public p308(int[][] matrix) {
        this.matrix = matrix;
        M = matrix.length;
        N = M == 0? 0: matrix[0].length;
        tree = new int[M+1][N+1];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        if (M == 0 || N == 0) return;
        int delta = val - tree[row][col];
        for (int i = row+1; i <= M; i += i & (-i)) {
            for (int j = col+1; j <= N; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }

    private int sum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= i & (-i)) {
            for (int j = col; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (M == 0 || N == 0) return 0;
        return sum(row2+1, col2+1) + sum(row1, col1) - sum(row2+1, col1) - sum(row1, col2+1);
    }
}
