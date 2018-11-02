public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean hasAbsentBefore = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                if (hasAbsentBefore) {
                    return false;
                } else {
                    hasAbsentBefore = true;
                }
            }
            if (c == 'L' && (i > 1 && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L')) {
                return false;
            }
        }
        return true;
    }
}
