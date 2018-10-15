import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res; // 1 2 3 4 8 12 11 10 9 5 6 7
        }
        int rowStart = 0, rowEnd = matrix.length - 1;  // 2    1
        int colStart = 0, colEnd = matrix[0].length - 1; // 1    2
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                res.add(matrix[rowStart][i]);
            }
            rowStart = rowStart + 1;
            for (int i = rowStart; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd = colEnd - 1;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd = rowEnd - 1;
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    res.add(matrix[i][colStart]);
                }
            }
            colStart = colStart + 1;
        }
        return res;
    }
}
