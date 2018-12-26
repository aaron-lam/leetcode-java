import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String cur = queue.poll();
                for (int i = 0; i < endWord.length(); i++) {
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder newWord = new StringBuilder(cur);
                        newWord.setCharAt(i, letter);
                        String newStr = newWord.toString();
                        if (set.contains(newStr)) {
                            if (newStr.equals(endWord)) {
                                return step + 1;
                            }
                            set.remove(newStr);
                            queue.offer(newStr);
                        }
                    }
                }
                size -= 1;
            }
            step += 1;
        }
        return 0;
    }
}
