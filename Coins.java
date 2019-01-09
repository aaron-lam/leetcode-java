public class Coins {

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 50, 100, 500};
        int[] nums = {3, 2, 1, 3, 0, 2};
        System.out.println(minUsage(coins, nums, 620));
    }

    private static int minUsage(int[] coins, int[] nums, int target) {
        if (coins == null || nums == null || target <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int times = Math.min(target / coins[i], nums[i]);
            target -= coins[i] * times;
            count += times;
        }
        return count;
    }
}
