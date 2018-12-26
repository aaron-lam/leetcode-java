import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(removeKdigits("112", 1));
    }

    public static String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return "";
        }
        if (k == num.length()) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        // iterate through the num String,
        // use stack to store (n - k) smallest numbers
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            // if the current number is smaller than
            while (!stack.isEmpty() && c < stack.peek() && k > 0) {
                stack.pop();
                k -= 1;
            }
            stack.push(c);
        }
        // pop out excessive numbers to get (n - k) smallest numbers
        while (k > 0) {
            stack.pop();
            k -= 1;
        }
        // build the result String from the stack ((n - k) smallest numbers)
        constructStrFromStack(res, stack);
        // remove the front of zeroes in the result String
        removeFrontZeroes(res);
        return res.toString();
    }

    private static void constructStrFromStack(StringBuilder res, Stack stack) {
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res.reverse();
    }

    private static void removeFrontZeroes(StringBuilder res) {
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
    }
}
