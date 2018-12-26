public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) {
            return new int[0][0];
        }
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                add(res, count, nums[i][j]);
                count += 1;
            }
        }
        return res;
    }

    private void add(int[][] res, int count, int num) {
        int row = count / res[0].length;
        int col = count % res[0].length;
        res[row][col] = num;
    }
}
