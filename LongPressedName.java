public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null) {
            return true;
        }
        int j = 0, m = name.length(), n = typed.length();
        for (int i = 0; i < n; i++) {
            if (j < m && name.charAt(j) == typed.charAt(i)) {
                j += 1;
            } else if (i == 0 || typed.charAt(i) != typed.charAt(i - 1)) {
                return false;
            }
        }
        return j == m;
    }
}
