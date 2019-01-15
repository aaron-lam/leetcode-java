import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        if (head == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int val : G) {
            set.add(val);
        }
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            if (set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val))) {
                res += 1;
            }
            cur = cur.next;
        }
        return res;
    }
}
