public class UglyNumber {

    public boolean isUgly(int num) {
        if (num < 0) {
            return false;
        }
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
