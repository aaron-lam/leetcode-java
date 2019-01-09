import java.util.LinkedList;
import java.util.Queue;

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public boolean isUnivalTreeIter(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int v = root.val;
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n.val != v) {
                return false;
            }
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }
        return true;
    }
}
