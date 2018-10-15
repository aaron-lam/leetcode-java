public class FindFirstAndLastIndexInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{ -1, -1 };
        }
        int lowIndex = searchIndex(nums, target, "low");
        int highIndex = searchIndex(nums, target, "high");
        return new int[]{lowIndex, highIndex};
    }

    private int searchIndex(int[] nums, int target, String lowOrHigh) {
        int index = -1;
        if (nums == null || nums.length == 0) {
            return index;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                index = mid;
                if (lowOrHigh.equals("low")) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }
}
