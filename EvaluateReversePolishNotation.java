import java.util.Stack;

class EvaluateReversePolishNotation {

    public int evalRPN(String tokens[]) {
        if (tokens == null || tokens.length == 0) {
            return Integer.MIN_VALUE;
        }
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = st.pop();
                int num1 = st.pop();
                switch (token) {
                    case "+":
                        st.push(num1 + num2);
                        break;
                    case "-":
                        st.push(num1 - num2);
                        break;
                    case "*":
                        st.push(num1 * num2);
                        break;
                    case "/":
                        st.push(num1 / num2);
                }
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
