import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndex[S.charAt(i) - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
