public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        // check if null
        // init arr (for counting char frequencies)
        // traverse through s
        //      increment arr if found char
        // init HashSet<Character> (s char)
        // traverse through arr
        //      if arr value is 1
        //            add char to set
        // traverse through s again
        //      if current char contains in set
        //             return its index
        // return -1
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
