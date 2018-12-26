public class SearchIn2DMatrix {

    Point isInMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int r = 0, c = column - 1;
        while (r < row && c >= 0) {
            if (matrix[r][c] == target) {
                return new Point(r, c);
            }
            if (matrix[r][c] > target) {
                c -= 1;
            } else {
                r += 1;
            }
        }
        return new Point(-1, -1);
    }
}
