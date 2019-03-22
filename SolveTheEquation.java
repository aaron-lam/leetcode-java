public class SolveTheEquation {

    public String solveEquation(String equation) {
        if (equation == null || equation.length() == 0) {
            return "";
        }
        String[] eq = equation.split("=");
        int[] left = evaluate(eq[0]);
        int[] right = evaluate(eq[1]);
        left[0] -= right[0];
        left[1] = right[1] - left[1];
        if (left[0] == 0 && left[1] == 0) {
            return "Infinite solutions";
        }
        if (left[0] == 0) {
            return "No solution";
        }
        return "x=" + left[1] / left[0];
    }

    public int[] evaluate(String exp) {
        String[] tokens = exp.split("(?=[-+])");
        int[] res = new int[2];
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) {
                res[0] += 1;
            } else if (token.equals("-x")) {
                res[0] -= 1;
            } else if (token.contains("x")) {
                res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            } else {
                res[1] += Integer.parseInt(token);
            }
        }
        return res;
    }
}
