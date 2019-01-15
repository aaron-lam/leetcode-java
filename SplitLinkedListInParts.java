public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        for (ListNode cur = root; cur != null; cur = cur.next) {
            len += 1;
        }
        ListNode[] res = new ListNode[k];
        int num = len / k, extra = len % k;
        ListNode cur = root, prev = null;
        for (int i = 0; cur != null; i++, extra--) {
            res[i] = cur;
            for (int j = 0; j < num + (extra > 0 ? 1 : 0); j++) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = null;
        }
        return res;
    }
}
