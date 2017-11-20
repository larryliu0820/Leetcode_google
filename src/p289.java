/**
 * Created by Larry Liu on 11/19/2017.
 * 289. Game of Life
 */
public class p289 {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lives = numOfLiveNeighbors(board, i, j);
                if (board[i][j] == 1 && (lives == 3 || lives == 2)) board[i][j] = 3;
                else if (board[i][j] == 0 && lives == 3) board[i][j] = 2;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] /= 2;
            }
        }
    }

    private int numOfLiveNeighbors(int[][] board, int row, int col) {
        int live = 0;
        if (row > 0) {
            for (int i = Math.max(0,col - 1); i < Math.min(col+2, board[0].length); i++) {
                live += board[row-1][i] % 2;
            }
        }
        if (col > 0) live += board[row][col-1] % 2;
        if (col < board[0].length-1) live += board[row][col+1] % 2;
        if (row < board.length - 1) {
            for (int i = Math.max(0,col - 1); i < Math.min(col+2, board[0].length); i++) {
                live += board[row+1][i] % 2;
            }
        }
        return live;
    }
}
