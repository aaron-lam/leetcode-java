import java.util.HashSet;

public class longestPalindrome {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.add(c)) {
                set.remove(c);
                count += 1;
            }
        }
        if (!set.isEmpty()) {
            return 2 * count + 1;
        }
        return 2 * count;
    }
}
