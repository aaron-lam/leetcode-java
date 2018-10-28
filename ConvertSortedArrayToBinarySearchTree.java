public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return traverse(nums, 0, nums.length - 1);
    }

    private TreeNode traverse(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traverse(nums, start, mid - 1);
        root.right = traverse(nums, mid + 1, end);
        return root;
    }
}
