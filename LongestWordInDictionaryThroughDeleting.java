import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        if (s == null || d == null) {
            return "";
        }
        String res = "";
        for (String subStr : d) {
            if (isSubsequence(subStr, s)) {
                if (subStr.length() > res.length() ||
                        (subStr.length() == res.length() && subStr.compareTo(res) < 0)) {
                    res = subStr;
                }
            }
        }
        return res;
    }

    public boolean isSubsequence(String subStr, String s) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < subStr.length() && subStr.charAt(j) == s.charAt(i)) {
                j += 1;
            }
        }
        return j == subStr.length();
    }
}
