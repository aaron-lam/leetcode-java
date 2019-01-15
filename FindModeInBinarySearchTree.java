import java.util.LinkedList;
import java.util.List;

public class FindModeInBinarySearchTree {
    private List<Integer> list;
    private Integer prev;
    private int count;
    private int max;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        list = new LinkedList<>();
        prev = null;
        count = 1;
        max = 0;

        traverse(root);

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (prev != null) {
            if (root.val == prev) {
                count += 1;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right);
    }
}
