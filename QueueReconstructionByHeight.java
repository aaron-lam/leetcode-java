import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] != b[0] ? b[0] - a[0] : a[1] - b[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }
}
