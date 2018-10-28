import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        backtrack(res, new ArrayList<>(), s, 0, s.length());
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> list, String s, int start, int end) {
        if (start == end) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= end; i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i));
                backtrack(res, list, s, i, end);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start == end - 1) {
            return true;
        }
        while (start < end - 1) {
            if (s.charAt(start) != s.charAt(end - 1)) {
                return false;
            }
            start = start + 1;
            end = end - 1;
        }
        return true;
    }
}
