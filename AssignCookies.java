import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; j < s.length && i < g.length; j++) {
            if (g[i] <= s[j]) {
                i += 1;
            }
        }
        return i;
    }
}
