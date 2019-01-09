public class DFS {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7};
        System.out.println(dfs(nums, 0, 13, 0));
        System.out.println(dfs(nums, 0, 15, 0));
    }

    public static boolean dfs(int[] nums, int cur, int sum, int i) {
        if (i == nums.length) {
            return cur == sum;
        }
        if (dfs(nums, cur, sum, i + 1)) {
            return true;
        }
        if (dfs(nums, cur + nums[i], sum, i + 1)) {
            return true;
        }
        return false;
    }
}
