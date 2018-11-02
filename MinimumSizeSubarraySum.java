public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s < 1) {
            return 0;
        }
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            j = j + 1;
            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i];
                i = i + 1;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
