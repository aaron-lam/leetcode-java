import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) {
            return "";
        }

        Set<String> bannedSet = new HashSet<>();
        if (banned != null && banned.length != 0) {
            bannedSet = new HashSet<>(Arrays.asList(banned));
        }

        String res = "";
        String[] words = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            word = filter(word);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int maxTimes = 0;
        for (String word : map.keySet()) {
            if (map.get(word) > maxTimes && !bannedSet.contains(word)) {
                res = word;
                maxTimes = map.get(word);
            }
        }

        return res;
    }

    private String filter(String word) {
        StringBuilder filteredStr = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!Character.isLetter(c)) {
                break;
            }
            filteredStr.append(Character.toLowerCase(c));
        }
        return filteredStr.toString();
    }
}
