import java.util.HashSet;

public class MaxDiffTwoSubsets {
    public static void main(String[] args) {
        int arr[] = { 4, 2, -3, 3, -2, -2, 8 };
        System.out.println(maxDiffTwoSubsets(arr));
    }

    public static int maxDiffTwoSubsets(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MAX_VALUE;
        }
        HashSet<Integer> positiveSet = new HashSet<>();
        HashSet<Integer> negativeSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positiveSet.add(arr[i]);
            } else {
                if (!negativeSet.add(arr[i])) {
                    negativeSet.remove(arr[i]);
                }
            }
        }
        int positiveSum = 0, negativeSum = 0;
        for (int positiveNum : positiveSet) {
            positiveSum += positiveNum;
        }
        for (int negativeNum : negativeSet) {
            negativeSum += negativeNum;
        }
        return Math.abs(positiveSum - negativeSum);
    }
}
