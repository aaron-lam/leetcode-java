class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        int val = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = val;
                val = val + 1;
            }
            rowStart = rowStart + 1;
            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = val;
                val = val + 1;
            }
            colEnd = colEnd - 1;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    res[rowEnd][i] = val;
                    val = val + 1;
                }
            }
            rowEnd = rowEnd - 1;
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    res[i][colStart] = val;
                    val = val + 1;
                }
            }
            colStart = colStart + 1;
        }
        return res;
    }
}
