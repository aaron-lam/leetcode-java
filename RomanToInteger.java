import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res += map.get(c);
            if (i != 0 && map.get(s.charAt(i - 1)) < map.get(c)) {
                res -= map.get(s.charAt(i - 1)) * 2;
            }
        }
        return res;
    }
}
