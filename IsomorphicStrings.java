public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] arrS = new int[256], arrT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (arrS[s.charAt(i)] != arrT[t.charAt(i)]) {
                return false;
            }
            arrS[s.charAt(i)] = i + 1;
            arrT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
