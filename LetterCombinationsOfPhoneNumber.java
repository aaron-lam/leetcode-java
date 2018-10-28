import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] phone = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        dfs(digits, res, "", phone, 0);
        return res;
    }

    private void dfs(String digits, List<String> res, String cur, String[] phone, int len) {
        if (len == digits.length()) {
            res.add(cur);
            return;
        }
        String s = phone[digits.charAt(len) - '0'];
        for (int i = 0; i < s.length(); i++) {
            dfs(digits, res, cur + s.charAt(i), phone, len + 1);
        }
    }
}
