public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        if (s == null || t == null) {
            return '0';
        }
        int res = 0;
        for (int i = 0; i < t.length(); i++) {
            res += (int) (t.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            res -= (int) (s.charAt(i));
        }
        return (char) res;
    }
}
