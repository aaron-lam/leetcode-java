public class MajorityElement {

    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    public int majorityElement(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = (end - start) / 2 + start;

        int leftMajority = majorityElement(nums, start, mid);
        int rightMajority = majorityElement(nums, mid + 1, end);

        int leftCount = countFrequencies(nums, start, mid, leftMajority);
        int rightCount = countFrequencies(nums, mid + 1, end, rightMajority);

        return (leftCount > rightCount) ? leftMajority : rightMajority;
    }

    private int countFrequencies(int[] nums, int start, int end, int target) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                count += 1;
            }
        }
        return count;
    }
}
