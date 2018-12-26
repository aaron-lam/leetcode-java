public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        // if even number, move to left
        // if odd number, move to right
        if (A == null || A.length == 0) {
            return A;
        }
        int[] res = new int[A.length];
        int left = 0, right = res.length - 1;
        for (int num : A) {
            if (num % 2 == 0) {
                res[left] = num;
                left += 1;
            } else {
                res[right] = num;
                right -= 1;
            }
        }
        return res;
    }
}
