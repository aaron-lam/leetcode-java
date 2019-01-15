public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        helper(t, res);
        return res.toString();
    }

    public void helper(TreeNode t, StringBuilder res) {
        res.append(t.val);
        if (t.left == null && t.right == null) {
            return;
        }
        if (t.left != null) {
            res.append("(");
            helper(t.left, res);
            res.append(")");
        }
        if (t.right != null) {
            if (t.left == null) {
                res.append("()");
            }
            res.append("(");
            helper(t.right, res);
            res.append(")");
        }
    }
}
