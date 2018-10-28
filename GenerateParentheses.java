import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String cur, int left, int right, int n) {
        if (cur.length() == n * 2) {
            res.add(cur);
            return;
        }
        if (left < n) {
            backtrack(res, cur + "(", left + 1, right, n);
        }
        if (right < left) {
            backtrack(res, cur	 + ")", left, right + 1, n);
        }
    }

}
