public class SarumanArmy {

    public static void main(String[] args) {
        int[] nums = {1, 7, 15, 20, 30, 50};
        System.out.println(minSpot(nums, 10));
    }

    private static int minSpot(int[] nums, int maxDistance) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        int count = 0;
        while (index < nums.length) {
            int start = nums[index];
            index += 1;
            while (index < nums.length && nums[index] <= start + maxDistance) {
                index += 1;
            }
            int point = nums[index - 1];
            while (index < nums.length && nums[index] <= point + maxDistance) {
                index += 1;
            }
            count += 1;
        }
        return count;
    }
}
