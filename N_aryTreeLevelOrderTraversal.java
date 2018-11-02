import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_aryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 0;
        while (!queue.isEmpty()) {
            res.add(new ArrayList<>());
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                res.get(idx).add(node.val);
                for (Node child : node.children) {
                    queue.offer(child);
                }
                size -= 1;
            }
            idx += 1;
        }
        return res;
    }
}
