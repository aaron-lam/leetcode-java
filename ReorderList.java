public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // find the middle of the list
        ListNode p1 = head, p2 = head;
        while (p2.next != null && p2.next.next!= null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // reverse the right half
        ListNode preMid = p1;
        ListNode preCur = p1.next;
        while (preCur.next != null) {
            ListNode cur = preCur.next;
            preCur.next = cur.next;
            cur.next = preMid.next;
            preMid.next = cur;
        }

        // start reordering
        p1 = head;
        p2 = preMid.next;
        while (p1 != preMid) {
            preMid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMid.next;
        }
    }
}
