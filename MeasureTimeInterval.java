import java.util.Arrays;
import java.util.Comparator;

public class MeasureTimeInterval {

    public static void main(String[] args) {
        int[] start = {1, 1, 2, 4, 6, 8};
        int[] end = {10, 3, 5, 7, 9, 10};
        System.out.println(maxTimeInterval(start, end));
    }

    private static int maxTimeInterval(int[] start, int[] end) {
        if (start == null || end == null) {
            return 0;
        }
        assert(start.length == end.length);
        Interval[] intervals = new Interval[start.length];
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = new Interval(start[i], end[i]);
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        int res = 0, curTime = 0;
        for (Interval interval : intervals) {
            if (interval.start > curTime) {
                res += 1;
                curTime = interval.end;
            }
        }
        return res;
    }
}
