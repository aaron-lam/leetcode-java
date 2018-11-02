public class WordSearch {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 ||                                    board[i][j] != word.charAt(idx) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (search(board, word, i + 1, j, idx + 1) ||
                search(board, word, i - 1, j, idx + 1) ||
                search(board, word, i, j + 1, idx + 1) ||
                search(board, word, i, j - 1, idx + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
