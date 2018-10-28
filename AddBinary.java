public class AddBinary {

    public String addBinary(String a, String b) {
        if (a == null && b == null) {
            return "";
        }
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        StringBuilder res = new StringBuilder();
        int idxA = a.length() - 1, idxB = b.length() - 1, carry = 0;
        while (idxA >= 0 || idxB >= 0 || carry != 0) {
            int sum = carry;
            sum += (idxA >= 0) ? a.charAt(idxA) - '0' : 0;
            sum += (idxB >= 0) ? b.charAt(idxB) - '0' : 0;
            res.append(sum % 2);
            carry = sum / 2;
            idxA -= 1;
            idxB -= 1;
        }
        return res.reverse().toString();
    }
}
