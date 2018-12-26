import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        for (int i = 0; i < nums1.length && i < k; i++) {
            q.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k > 0 && !q.isEmpty()) {
            int[] cur = q.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length - 1) {
                continue;
            }
            q.offer(new int[] {cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}
