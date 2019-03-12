import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        if (source == null || source.length == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        boolean isInComment = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (isInComment) {
                    if (i < s.length() - 1 && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                        isInComment = false;
                        i += 1;
                    }
                } else {
                    if (i < s.length() - 1 && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                        break;
                    } else if (i < s.length() - 1 && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                        isInComment = true;
                        i += 1;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!isInComment && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
