import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        if (n <= 0 || k < 0) {
            return "";
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        StringBuilder res = new StringBuilder();
        int[] factorial = initFactorialArray(n);

        k -= 1;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            res.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return res.toString();
    }

    public int[] initFactorialArray(int n) {
        int sum = 1;
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        return factorial;
    }
}
