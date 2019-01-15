public class MinimumDistanceBetweenBSTNodes {

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return min;
        }
        minDiffInBST(root.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(root.val - prev));
        }
        prev = root.val;
        minDiffInBST(root.right);
        return min;
    }
}
