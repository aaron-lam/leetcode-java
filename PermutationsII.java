import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        backtrack(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] isUsed) {
        if (list.size() == nums.length) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i] || i > 0 && nums[i] == nums[i - 1] && isUsed[i - 1]) {
                continue;
            }
            isUsed[i] = true;
            list.add(nums[i]);
            backtrack(res, nums, list, isUsed);
            isUsed[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
