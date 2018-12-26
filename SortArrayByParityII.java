public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int[] res = new int[A.length];
        int evenIdx = 0, oddIdx = 1;
        for (int num : A) {
            if (num % 2 == 0) {
                res[evenIdx] = num;
                evenIdx += 2;
            } else {
                res[oddIdx] = num;
                oddIdx += 2;
            }
        }
        return res;
    }
}
