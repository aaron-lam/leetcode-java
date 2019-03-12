public class ValidNumber {

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        String regex = "^[+-]?(\\.\\d+|\\d+\\.?\\d*)(e[+-]?\\d+)?$";
        return s.matches(regex);
    }
}
