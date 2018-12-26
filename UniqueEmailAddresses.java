import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (c == '+' || c == '@') {
                    break;
                }
                if (c != '.') {
                    sb.append(c);
                }
            }
            int idx = email.indexOf('@');
            sb.append(email.substring(idx));
            set.add(sb.toString());
        }
        return set.size();
    }
}
