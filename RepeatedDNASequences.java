import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        HashSet<String> set = new HashSet<>();
        HashSet<String> addedSet = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String cur = s.substring(i, i + 10);
            if (!set.add(cur) && addedSet.add(cur)) {
                res.add(cur);
            }
        }
        return res;
    }
}
