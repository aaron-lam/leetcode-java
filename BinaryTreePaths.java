import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            traverse(root, res, "");
        }
        return res;
    }

    private void traverse(TreeNode root, List<String> res, String s) {
        if (root.left == null && root.right == null) {
            res.add(s + root.val);
            return;
        }
        if (root.left != null) {
            traverse(root.left, res, s + root.val + "->");
        }
        if (root.right != null) {
            traverse(root.right, res, s + root.val + "->");
        }
    }
}
