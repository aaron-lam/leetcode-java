public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = 0, col = 0, m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[row][col];
            if ((row + col) % 2 == 0) {
                if (col == n - 1) {
                    row += 1;
                } else if (row == 0) {
                    col += 1;
                } else {
                    row -= 1;
                    col += 1;
                }
            } else {
                if (row == m - 1) {
                    col += 1;
                } else if (col == 0) {
                    row += 1;
                } else {
                    row += 1;
                    col -= 1;
                }
            }
        }
        return res;
    }
}
