import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        remove(s, res, 0, 0, new char[] {'(', ')'});
        return res;
    }

    public void remove(String s, List<String> res, int lastI, int lastJ, char[] par) {
        int stack = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                stack += 1;
            }
            if (s.charAt(i) == par[1]) {
                stack -= 1;
            }
            if (stack >= 0) {
                continue;
            }
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(reversed, res, 0, 0, new char[] {')', '('});
        } else {
            res.add(reversed);
        }
    }
}
