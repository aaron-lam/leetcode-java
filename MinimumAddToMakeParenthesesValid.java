import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int numOfOpenBracket = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                numOfOpenBracket += 1;
            } else if (numOfOpenBracket == 0) {
                count += 1;
            } else {
                numOfOpenBracket -= 1;
            }
        }
        return numOfOpenBracket + count;
    }
}
