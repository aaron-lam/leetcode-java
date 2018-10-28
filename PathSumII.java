import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pathSum(res, new ArrayList<>(), root, sum);
        return res;
    }

    private void pathSum(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            res.add(new ArrayList<>(list));
        }
        pathSum(res, list, root.left, sum - root.val);
        pathSum(res, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
}
