import java.util.Arrays;

public class KDiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int start = 0, end = 1, count = 0;
        while (start < nums.length && end < nums.length) {
            if (start == end || nums[end] - nums[start] < k) {
                end += 1;
            } else if (nums[end] - nums[start] > k) {
                start += 1;
            } else {
                start += 1;
                count += 1;
                while (start < nums.length && nums[start] == nums[start - 1]) {
                    start += 1;
                }
                end = Math.max(end + 1, start + 1);
            }
        }
        return count;
    }
}
