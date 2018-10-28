import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return res;
        }
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int n, int k, int idx) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i <= n; i++) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            backtrack(res, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
