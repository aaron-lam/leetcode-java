public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count += 1;
        }
        if (sb.toString().contains(B)) {
            return count;
        }
        if (sb.append(A).toString().contains(B)) {
            return count + 1;
        }
        return -1;
    }
}
