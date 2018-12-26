import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return res;
        }
        for (int i = 0; i < input.length(); i++) {
            if (isOperator(input.charAt(i))) {
                String leftSubstring = input.substring(0, i);
                String rightSubstring = input.substring(i + 1);

                List<Integer> leftList = diffWaysToCompute(leftSubstring);
                List<Integer> rightList = diffWaysToCompute(rightSubstring);

                for (Integer num1 : leftList) {
                    for (Integer num2 : rightList) {
                        res.add(compute(num1, input.charAt(i), num2));
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    private int compute(int num1, char operator, int num2) {
        int res = 0;
        switch(operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
        }
        return res;
    }
}
