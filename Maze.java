import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    private final static int[][] direction = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    private static int[][] distances;

    static class Block {
        private int x;
        private int y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1}, {0, 1, 1, 1}, {0, 1, 0, 1}, {1, 1, 9, 1}, {0, 0, 1, 1}};
        int[][] grid2 = {{1, 0, 0}, {1, 0, 0}, {1, 9, 1}};
        System.out.println(maze(grid2));
    }

    public static int maze(int[][] matrix) {
        // null check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        initDistanceMatrix(matrix);
        // if the starting point is the final, return true
        if (matrix[0][0] == 9) {
            return 0;
        }
        // if (matrix[0][0] == 0) {
        //     return 0;
        // }
        int rows = matrix.length, cols = matrix[0].length;
        Queue<Block> queue = new LinkedList<>();
        queue.offer(new Block(0, 0));
        distances[0][0] = 0;
        while (!queue.isEmpty()) {
            Block cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextXCoor = cur.x + direction[i][0];
                int nextYCoor = cur.y + direction[i][1];
                Block nextBlock = new Block(nextXCoor, nextYCoor);
                // if the next block is not out of boundary
                if (isInBoundary(nextBlock, rows, cols) && !isVisited(nextBlock)) {
                    int square = matrix[nextBlock.x][nextBlock.y];
                    distances[nextBlock.x][nextBlock.y] = distances[cur.x][cur.y] + 1;
                    if (square == 9) {
                        return distances[nextBlock.x][nextBlock.y];
                    } else if (square == 1) {
                        queue.offer(nextBlock);
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private static void initDistanceMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            distances = new int[0][0];
            return;
        }
        distances = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[0].length; j++) {
                distances[i][j] = -1;
            }
        }
    }

    private static boolean isInBoundary(Block block, int rows, int cols) {
        return block.x >= 0 && block.x < rows && block.y >= 0 && block.y < cols;
    }

    private static boolean isVisited(Block block) {
        return distances[block.x][block.y] != -1;
    }
}
