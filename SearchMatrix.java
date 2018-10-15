public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, col = 0;
        while (row < matrix.length && col < matrix[0].length) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            } else if (row < matrix.length - 1 && target >= matrix[row + 1][col]) {
                row = row + 1;
            } else if (col < matrix[0].length - 1 && target >= matrix[row][col + 1]) {
                col = col + 1;
            } else {
                return false;
            }
        }
        return false;
    }
}
