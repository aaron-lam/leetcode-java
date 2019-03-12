import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        backtrack(S.toCharArray(), res, 0);
        return res;
    }

    public void backtrack(char[] sArr, List<String> res, int idx) {
        if (idx == sArr.length) {
            res.add(new String(sArr));
            return;
        }
        if (sArr[idx] >= '0' && sArr[idx] <= '9') {
            backtrack(sArr, res, idx + 1);
            return;
        }
        sArr[idx] = Character.toLowerCase(sArr[idx]);
        backtrack(sArr, res, idx + 1);

        sArr[idx] = Character.toUpperCase(sArr[idx]);
        backtrack(sArr, res, idx + 1);
    }
}
