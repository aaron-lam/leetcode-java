public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        if (licensePlate == null || words == null) {
            return "";
        }
        String target = licensePlate.toLowerCase();
        int[] map = new int[26];
        String res = "";
        int minLen = Integer.MAX_VALUE;
        recordFreq(map, target);
        for (String word : words) {
            if (isComplete(map, word) && word.length() < minLen) {
                minLen = word.length();
                res = word;
            }
        }
        return res;
    }

    private void recordFreq(int[] map, String licensePlate) {
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                map[c - 'a'] += 1;
            }
        }
    }

    private boolean isComplete(int[] map, String word) {
        int[] wordMap = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            wordMap[c - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > wordMap[i]) {
                return false;
            }
        }
        return true;
    }
}
