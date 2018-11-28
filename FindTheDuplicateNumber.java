public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int count = countNotGreaterThan(nums, mid);
            if (count <= mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private int countNotGreaterThan(int[] nums, int mid) {
        int count = 0;
        for (int num : nums) {
            if (num <= mid) {
                count += 1;
            }
        }
        return count;
    }
}
