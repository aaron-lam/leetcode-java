import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            res.add(new ArrayList<>());
            res.get(i).add(1);
            addFromPrevList(res.get(i), res.get(i - 1));
            res.get(i).add(1);
        }
        return res;
    }

    private void addFromPrevList(List<Integer> cur, List<Integer> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        for (int i = 1; i < list.size(); i++) {
            int sum = list.get(i) + list.get(i - 1);
            cur.add(sum);
        }
    }
}
