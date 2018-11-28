public class AddStrings {

    public String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return "";
        }
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int idx1 = len1 - 1, idx2 = len2 - 1;
        while (idx1 >= 0 || idx2 >= 0 || carry != 0) {
            int sum = carry;
            sum += getNum(num1, idx1);
            sum += getNum(num2, idx2);
            carry = sum / 10;
            res.append(sum % 10);
            idx1 -= 1;
            idx2 -= 1;
        }
        return res.reverse().toString();
    }

    private int getNum(String s, int idx) {
        if (idx < 0) {
            return 0;
        }
        return s.charAt(idx) - '0';
    }
}
