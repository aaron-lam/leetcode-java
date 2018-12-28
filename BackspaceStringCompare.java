public class BackspaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {
        return filter(S).equals(filter(T));
    }

    private static String filter(String s) {
        StringBuilder res = new StringBuilder();
        int backspaceCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                backspaceCount += 1;
            } else if (backspaceCount != 0) {
                backspaceCount -= 1;
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
