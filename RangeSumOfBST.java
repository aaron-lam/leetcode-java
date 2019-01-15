public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int val = (root.val >= L && root.val <= R) ? root.val : 0;
        return val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
