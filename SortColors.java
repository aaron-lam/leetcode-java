public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int i = 0;
        while (i <= rightIndex) {
            if (nums[i] == 0) {
                swap(nums, leftIndex, i);
                leftIndex = leftIndex + 1;
                i = i + 1;
            } else if (nums[i] == 1) {
                i = i + 1;
            } else {
                swap(nums, i, rightIndex);
                rightIndex = rightIndex - 1;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

