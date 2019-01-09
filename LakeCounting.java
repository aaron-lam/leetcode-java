public class LakeCounting {

    public static void main(String[] args) {
        char[][] garden = {{'W', '.', '.', '.'},
                           {'W', 'W', '.', 'W'},
                           {'W', '.', '.', '.'},
                           {'.', 'W', '.', 'W'}};
        System.out.println(lakeCounting(garden));
    }

    public static int lakeCounting(char[][] garden) {
        if (garden == null || garden.length == 0 || garden[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[0].length; j++) {
                if (garden[i][j] == 'W') {
                    dfs(garden, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] garden, int i, int j) {
        if (i < 0 || i > garden.length || j < 0 || j > garden[0].length) {
            return;
        }
        garden[i][j] = '.';
        int[][] directions = {{-1, -1}, {0, -1}, {1, -1},
                              {-1, 0}, {1, 0},
                              {-1, 1}, {0, 1}, {1, 1}};
        for (int[] direction : directions) {
            int x = i + direction[0], y = j + direction[1];
            if (0 <= x && x < garden.length && 0 <= y && y < garden[0].length &&
                    garden[x][y] == 'W') {
                dfs(garden, x, y);
            }
        }
    }
}
