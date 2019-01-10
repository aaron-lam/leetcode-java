import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    class Solution {
        public int eraseOverlapIntervals(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval a, Interval b) {
                    return a.end - b.end;
                }
            });
            int end = intervals[0].end;
            int count = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i].start < end) {
                    count += 1;
                } else {
                    end = intervals[i].end;
                }
            }
            return count;
        }
    }
}
