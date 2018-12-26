import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int nextGreater = getNextGreater(map, nums2, nums1[i]);
            nums1[i] = nextGreater;
        }
        return nums1;
    }

    private int getNextGreater(Map<Integer, Integer> map, int[] nums, int num) {
        int idx = map.get(num);
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] > num) {
                return nums[i];
            }
        }
        return -1;
    }
}
