import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
            return "";
        }
        List<String> permuteList = new ArrayList<>();
        backtrack(permuteList, n, new StringBuilder());
        Collections.sort(permuteList);
        return permuteList.get(k - 1);
    }

    private void backtrack(List<String> permuteList, int n, StringBuilder sb) {
        if (sb.length() == n) {
            permuteList.add(sb.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            sb.append(i);
            backtrack(permuteList, n, sb);
            sb.setLength(sb.length() - 1);
        }
    }

}
