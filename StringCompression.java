public class StringCompression {

    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int res = 0, idx = 0;
        while (idx < chars.length) {
            char curChar = chars[idx];
            int count = 0;
            while (idx < chars.length && chars[idx] == curChar) {
                idx += 1;
                count += 1;
            }
            chars[res++] = curChar;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[res++] = c;
                }
            }
        }
        return res;
    }
}
