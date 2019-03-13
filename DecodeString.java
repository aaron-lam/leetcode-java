import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        if (s == null) {
            return "";
        }
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx += 1;
                }
                countStack.push(count);
            } else if (c == '[') {
                resStack.push(res);
                res = "";
                idx += 1;
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int times = countStack.pop();
                for (int i = 0; i < times; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx += 1;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
