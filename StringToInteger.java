public class StringToInteger {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int idx = 0, sign = 1, res = 0;
        while (idx < str.length() && str.charAt(idx) == ' ') {
            idx = idx + 1;
        }
        if (idx == str.length()) {
            return 0;
        }
        if (str.charAt(idx) == '+' || str.charAt(idx) == '-') {
            sign = str.charAt(idx) == '+' ? 1 : -1;
            idx = idx + 1;
        }
        while (idx < str.length() && Character.isDigit(str.charAt(idx))) {
            int digit = str.charAt(idx) - '0';
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && 7 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            idx = idx + 1;
        }
        return res * sign;
    }
}
