public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 10, base = 9;
        for (int i = 9, j = n - 1; i > 0 && j > 0; i--, j--) {
            base *= i;
            res += base;
        }
        return res;
    }
}
