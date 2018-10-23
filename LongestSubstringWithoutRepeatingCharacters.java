import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int idx = 0, maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                idx = Math.max(idx, map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - idx + 1);
        }
        return maxLen;
    }
}
