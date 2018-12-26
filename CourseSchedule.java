import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]] += 1;
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                // if found the match prerequisite course
                if (x == prerequisites[i][0]) {
                    inDegree[prerequisites[i][1]] -= 1;
                    // if the course is no longer need prerequisite course
                    if (inDegree[prerequisites[i][1]] == 0) {
                        queue.offer(prerequisites[i][1]);
                    }
                }
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
