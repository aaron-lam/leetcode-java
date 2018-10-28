public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int res) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return res * 10 + root.val;
        }
        res = res * 10 + root.val;
        return sumNumbers(root.left, res) + sumNumbers(root.right, res);
    }
}
