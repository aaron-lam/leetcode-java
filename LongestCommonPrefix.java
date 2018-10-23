import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);
        char[] shortWord = strs[0].toCharArray();
        char[] longWord = strs[strs.length - 1].toCharArray();
        for (int i = 0; i < shortWord.length; i++) {
            if (shortWord[i] == longWord[i]) {
                res.append(shortWord[i]);
            } else {
                break;
            }
        }
        return res.toString();
    }
}
