import java.util.*;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        return toArray(res);
    }

    private int[] toArray(Set<Integer> set) {
        int[] res = new int[set.size()];
        int idx = 0;
        for (Integer i : set) {
            res[idx] = i;
            idx += 1;
        }
        return res;
    }
}
