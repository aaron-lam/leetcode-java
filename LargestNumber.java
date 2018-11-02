import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comparator = (s1, s2) -> {
            String combination1 = s1 + s2;
            String combination2 = s2 + s1;
            return combination2.compareTo(combination1);
        };
        Arrays.sort(numsStr, comparator);
        if (numsStr[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String s : numsStr) {
            res.append(s);
        }
        return res.toString();
    }
}
