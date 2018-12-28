public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        int incCount = 1, decCount = 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                incCount += 1;
            } else if (A[i] > A[i + 1]) {
                decCount += 1;
            } else {
                incCount += 1;
                decCount += 1;
            }
        }
        return incCount == A.length || decCount == A.length;
    }
}
