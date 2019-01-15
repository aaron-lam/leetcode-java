import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root.right != null) {
                q.offer(root.right);
            }
            if (root.left != null) {
                q.offer(root.left);
            }
        }
        return root.val;
    }
}
