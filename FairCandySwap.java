import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        if (A == null || B == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        int sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            set.add(A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }
        int diff = (sumA - sumB) / 2;
        for (int i = 0; i < B.length; i++) {
            if (set.contains(B[i] + diff)) {
                return new int[]{B[i] + diff, B[i]};
            }
        }
        return new int[0];
    }
}
