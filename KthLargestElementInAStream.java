import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    private final PriorityQueue<Integer> queue;
    private final int k;

    public KthLargestElementInAStream(int k, int[] a) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int n : a) {
            add(n);
        }
    }

    public int add(int n) {
        if (queue.size() < k) {
            queue.offer(n);
        } else if (queue.peek() < n) {
            queue.poll();
            queue.offer(n);
        }
        return queue.peek();
    }
}
