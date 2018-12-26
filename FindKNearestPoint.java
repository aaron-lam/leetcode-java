import java.util.PriorityQueue;

// We use priority queue in order to find the K nearest point.
// First we do null check first.
// We initialize the priorityQueue, and we always keep the nearest point in queue
// We keep popping out the priority queue's element into array
// return the array
// Space : O(K) Time: O(NlogK)

public class FindKNearestPoint {

    public Point[] findKNearestPoint(Point[] array, Point origin, int k) {
        Point[] rvalue = new Point[k];
        int index = 0;
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(k, (a, b) ->
                (int) (getDistance(a, origin) - getDistance(b, origin))
        );
        for (Point point : array) {
            priorityQueue.offer(point);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()) {
            rvalue[index] = priorityQueue.poll();
            index += 1;
        }
        return rvalue;
    }

    private static double getDistance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) - (a.y - b.y) * (a.y - b.y));
    }
}
