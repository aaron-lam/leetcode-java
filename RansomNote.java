import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        // check if null
        // init map<Character, Integer> (letter, frequencies)
        // traverse through magazine, record letter and its frequencies {a : 2, b : 1}
        // traverse through ransomNote
        //       if not find a ransomNote in the map, return false
        //       if find in the map
        //              if the frequencies is 0, return false
        //              else                     decrement the frequency
        // return true
        if (ransomNote == null || ransomNote.length() == 0) {
            return true;
        }
        if (magazine == null || magazine.length() == 0) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ransomChar = ransomNote.charAt(i);
            if (!map.containsKey(ransomChar)) {
                return false;
            } else {
                if (map.get(ransomChar) == 0) {
                    return false;
                } else {
                    map.put(ransomChar, map.get(ransomChar) - 1);
                }
            }
        }
        return true;
    }
}
