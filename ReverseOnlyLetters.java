public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder(S);
        int low = 0, high = S.length() - 1;
        while (low < high) {
            while (low < high && !Character.isLetter(S.charAt(low))) {
                low += 1;
            }
            while (low < high && !Character.isLetter(S.charAt(high))) {
                high -= 1;
            }
            res.setCharAt(low, S.charAt(high));
            res.setCharAt(high, S.charAt(low));
            low += 1;
            high -= 1;
        }
        return res.toString();
    }
}
