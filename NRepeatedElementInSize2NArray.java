import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInSize2NArray {

    public int repeatedNTimes(int[] A) {
        if (A == null || A.length == 0) {
            return Integer.MIN_VALUE;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (!set.add(num)) {
                return num;
            }
        }
        return Integer.MIN_VALUE;
    }
}
