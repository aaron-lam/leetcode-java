import java.util.LinkedList;
import java.util.Queue;

public class MazeShortestDistance {

    public static void main(String[] args) {
        char[][] maze = {{'S', '.', '.', '.'},
                         {'.', '#', '#', '.'},
                         {'.', '#', '.', '.'},
                         {'.', '#', 'G', '.'}};
        System.out.println(shortestDistance(maze));
    }

    private static int shortestDistance(char[][] maze) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return 0;
        }
        int[][] directions = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
        int[][] distances = new int[maze.length][maze[0].length];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }
        Point start = findPoint(maze, 'S');
        Point end = findPoint(maze, 'G');
        queue.offer(start);
        distances[start.x][start.y] = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == end.x && p.y == end.y) {
                break;
            }
            for (int[] direction : directions) {
                int x = p.x + direction[0], y = p.y + direction[1];
                if (0 <= x && x < maze.length && 0 <= y && y < maze[0].length &&
                        maze[x][y] != '#' && distances[x][y] == Integer.MAX_VALUE) {
                    queue.offer(new Point(x, y));
                    distances[x][y] = distances[p.x][p.y] + 1;
                }
            }
        }
        return distances[end.x][end.y];
    }

    private static Point findPoint(char[][] maze, char target) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == target) {
                    return new Point(i, j);
                }
            }
        }
        return new Point(-1, -1);
    }
}
