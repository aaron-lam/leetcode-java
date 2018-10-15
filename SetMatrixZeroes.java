public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean hasZeroInFirstRow = false, hasZeroInFirstCol = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                hasZeroInFirstRow = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                hasZeroInFirstCol = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                changeColToZero(matrix, i);
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                changeRowToZero(matrix, i);
            }
        }
        if (hasZeroInFirstRow) {
            changeRowToZero(matrix, 0);
        }
        if (hasZeroInFirstCol) {
            changeColToZero(matrix, 0);
        }
    }

    private void changeRowToZero(int[][] matrix, int rowIndex) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[rowIndex][i] = 0;
        }
    }

    private void changeColToZero(int[][] matrix, int colIndex) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][colIndex] = 0;
        }
    }
}
