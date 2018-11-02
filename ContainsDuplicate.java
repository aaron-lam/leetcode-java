import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashSet<Integer> duplicateSet = new HashSet<>();
        for (int n : nums) {
            if (!duplicateSet.add(n)) {
                return true;
            }
        }
        return false;
    }
}
