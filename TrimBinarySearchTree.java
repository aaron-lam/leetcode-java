// Write Java code here

public class TrimBinarySearchTree {
    static TreeNode root;

    // Removes all TreeNodes having value
    // outside the given range and
    // returns the root of modified tree
    private static TreeNode removeOutsideRange(TreeNode root, int min, int max) {
        // BASE CASE
        if (root == null) {
            return null;
        }
        // FIRST FIX THE LEFT AND
        // RIGHT SUBTREE OF ROOT
        root.left = removeOutsideRange(root.left, min, max);
        root.right = removeOutsideRange(root.right, min, max);

        // NOW FIX THE ROOT. THERE ARE
        // TWO POSSIBLE CASES FOR THE ROOT
        // 1. a) Root's val is smaller than
        // min value(root is not in range)
        if (root.val < min) {
            TreeNode rchild = root.right;
            root = null;
            return rchild;
        }

        // 1. b) Root's val is greater than
        // max value (Root is not in range)
        if (root.val > max) {
            TreeNode lchild = root.left;
            root = null;
            return lchild;
        }

        // 2. Root in range
        return root;
    }

    public static TreeNode newTreeNode(int num) {
        TreeNode temp = new TreeNode(num);
        temp.left = null;
        temp.right = null;
        return temp;
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return newTreeNode(val);
        }
        if (root.val > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    // Driver code
    public static void main(String[] args) {
        root = null;
        root = insert(root, 6);
        root = insert(root, -13);
        root = insert(root, 14);
        root = insert(root, -8);
        root = insert(root, 15);
        root = insert(root, 13);
        root = insert(root, 7);

        System.out.print("Inorder Traversal of the given tree is: ");
        inorderTraversal(root);

        root = trim(-10, 13);

        System.out.print("\nInorder traversal of the modified tree: ");
        inorderTraversal(root);
    }

    public static TreeNode trim(int min, int max) {
        return trim(root, min, max);
    }

    public static TreeNode trim(TreeNode node, int min, int max) {
        // base case
        if (node == null) {
            return null;
        }
        // code
        if (node.val < min) {
            return trim(node.right, min, max);
        }
        if (node.val > max) {
            return trim(node.left, min, max);
        }
        // traverse the tree
        node.left = trim(node.left, min, max);
        node.right = trim(node.right, min, max);
        // return the node after traversing both sides recursively
        return node;
    }
}
