import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > S.length()) {
                return "";
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue(map.size(), new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        for (Character c : map.keySet()) {
            pq.offer(new int[] {(int) c, map.get(c)});
        }
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] data = pq.poll();
            char c = (char) data[0];
            if (res.length() == 0 || c != res.charAt(res.length() - 1)) {
                res.append(c);
                data[1] -= 1;
                if (data[1] > 0) {
                    pq.offer(data);
                }
            } else {
                int[] data2 = pq.poll();
                if (data2 == null) {
                    return "";
                }
                res.append((char) data2[0]);
                data2[1] -= 1;
                if (data2[1] > 0) {
                    pq.offer(data2);
                }
                pq.offer(data);
            }
        }
        return res.toString();
    }
}
