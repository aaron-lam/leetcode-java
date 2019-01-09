public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }
        TreeNode res = increasingBST(root.left, null);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }
}
