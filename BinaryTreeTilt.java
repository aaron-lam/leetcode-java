public class BinaryTreeTilt {

    int res = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findTilt(root, 0);
        return res;
    }

    public int findTilt(TreeNode root, int tilt) {
        if (root == null) {
            return 0;
        }
        int left = findTilt(root.left, tilt);
        int right = findTilt(root.right, tilt);
        res += Math.abs(left - right);
        return root.val + left + right;
    }
}
