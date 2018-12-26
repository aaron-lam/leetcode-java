public class DIStringMatch {

    public int[] diStringMatch(String S) {
        if (S == null || S.length() == 0) {
            return new int[0];
        }
        int[] res = new int[S.length() + 1];
        int left = 0, right = S.length();
        for (int i = 0; i < S.length(); i++) {
            res[i] = (S.charAt(i) == 'I') ? left++ : right--;
        }
        res[S.length()] = left;
        return res;
    }
}
