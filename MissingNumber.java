public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int sum = (len * (len + 1)) / 2;
        for (int n : nums) {
            sum -= n;
        }
        return sum;
    }
}
