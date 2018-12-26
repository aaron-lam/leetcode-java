public class GameOfLife {

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int lives = countNearbyLives(board, rows, cols, i, j);
                if (board[i][j] == 1 && (lives == 2 || lives == 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int countNearbyLives(int[][] board, int rows, int cols, int i, int j) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int lives = 0;
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] d : dir) {
            int di = d[0] + i, dj = d[1] + j;
            if (di >= 0 && di < rows && dj >= 0 && dj < cols) {
                lives += board[di][dj] & 1;
            }
        }
        return lives;
    }
}
