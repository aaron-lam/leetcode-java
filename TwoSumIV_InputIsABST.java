import java.util.ArrayList;
import java.util.List;

public class TwoSumIV_InputIsABST {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int start = 0, end = list.size() - 1;
        while (start < end) {
            int sum = list.get(start) + list.get(end);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                start += 1;
            } else {
                end -= 1;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
