import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, 0);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res, int i) {
        if (root == null) {
            return;
        }
        if (res.size() <= i) {
            res.add(root.val);
        } else {
            int max = Math.max(res.get(i), root.val);
            res.set(i, max);
        }
        helper(root.left, res, i + 1);
        helper(root.right, res, i + 1);
    }
}
