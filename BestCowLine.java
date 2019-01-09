public class BestCowLine {

    public static void main(String[] args) {
        System.out.println(bestCowLine("ACDBCB"));
    }

    private static String bestCowLine(String s) {
        int m = s.length();
        char[] charArr = s.toCharArray();
        int start = 0, end = m - 1;
        StringBuilder res = new StringBuilder();
        while (start <= end) {
            boolean isLeftSmaller = false;
            for (int i = 0; start + i < end - i; i++) {
                if (charArr[start + i] < charArr[end - i]) {
                    isLeftSmaller = true;
                    break;
                } else if (charArr[start + i] > charArr[end - i]) {
                    break;
                }
            }
            res.append((isLeftSmaller) ? charArr[start++] : charArr[end--]);
        }
        return res.toString();
    }
}
