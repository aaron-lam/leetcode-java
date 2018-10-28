import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(res, root, 0);
        return res;
    }

    private void traverse(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        traverse(res, root.left, depth + 1);
        traverse(res, root.right, depth + 1);
    }
}
