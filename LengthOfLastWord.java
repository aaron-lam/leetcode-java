public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int idx = s.length() - 1, len = 0;
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx -= 1;
        }
        while (idx >= 0 && Character.isLetter(s.charAt(idx))) {
            len += 1;
            idx -= 1;
        }
        return len;
    }
}
