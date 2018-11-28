import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || pattern.length() == 0 || str.length() == 0) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            char curPattern = pattern.charAt(i);
            if (map.containsKey(curPattern) && !map.get(curPattern).equals(arr[i])) {
                return false;
            }
            if (!map.containsKey(curPattern) && map.containsValue(arr[i])) {
                return false;
            }
            map.put(curPattern, arr[i]);
        }
        return true;
    }
}
