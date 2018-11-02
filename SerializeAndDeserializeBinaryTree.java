import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public class Codec {
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder res = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                root = queue.poll();
                if (root == null) {
                    res.append("null ");
                } else {
                    res.append(root.val + " ");
                    queue.add(root.left);
                    queue.add(root.right);
                }
            }
            return res.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            String[] values = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            queue.add(root);
            for (int i = 1; i < values.length; i++) {
                TreeNode parent = queue.poll();
                if (!values[i].equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    queue.add(left);
                }
                i = i + 1;
                if (!values[i].equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = right;
                    queue.add(right);
                }
            }
            return root;
        }
    }
}
