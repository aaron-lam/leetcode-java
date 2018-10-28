public class PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        TreeLinkNode prev = null;
        TreeLinkNode cur = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        root = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        root = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = root;
            root = null;
            prev = null;
        }
    }
}
