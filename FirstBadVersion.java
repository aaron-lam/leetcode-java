public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int start = 0, end = n;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public boolean isBadVersion(int n) {
        return false;
    }
}
