import java.util.HashSet;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        HashSet<Character> rowSet;
        HashSet<Character> colSet;
        HashSet<Character> squareSet;
        for (int i = 0; i < 9; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            squareSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }
                int rowIndex = 3 * (i / 3) + j % 3;
                int colIndex = 3 * (i % 3) + j / 3;
                if (board[rowIndex][colIndex] != '.' && !squareSet.add(board[rowIndex][colIndex])) {
                    return false;
                }
            }
        }
        return true;
    }
}
