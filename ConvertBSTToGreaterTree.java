public class ConvertBSTToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root, 0);
        return root;
    }

    public int helper(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        root.val += helper(root.right, sum);
        return helper(root.left, root.val);
    }
}
