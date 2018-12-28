import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new LinkedList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i += 1;
            } else if (nums1[i] > nums2[j]) {
                j += 1;
            } else {
                list.add(nums1[i]);
                i += 1;
                j += 1;
            }
        }
        return toArray(list);
    }

    private int[] toArray(List<Integer> list) {
        int[] res = new int[list.size()];
        int idx = 0;
        for (Integer i : list) {
            res[idx] = i;
            idx += 1;
        }
        return res;
    }
}
