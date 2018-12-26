import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    public static void main(String[] args) {
        int[][] arr = {{3,2}, {0,1}, {2,1}};
        System.out.println(findOrder(3, arr));
    }

    public static String findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][1]]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)  {
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                res.append(i);
                queue.offer(i);
            }
        }

        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        res.append(prerequisites[i][0]);
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return (res.length() == numCourses) ? res.toString() : "invalid";
    }
}
