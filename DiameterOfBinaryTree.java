public class DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDiameter(root);
        return max;
    }

    public int getDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDiameter(root.left);
        int right = getDiameter(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}