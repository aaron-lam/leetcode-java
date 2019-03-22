import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return res;
        }
        int start = 0, end = arr.length - k - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(arr[start + i]);
        }
        return res;
    }
}
