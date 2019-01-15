import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq =
                new PriorityQueue<>(map.size(), new Comparator<Character>() {
                    public int compare(Character a, Character b) {
                        return map.get(b) - map.get(a);
                    }
                });
        for (Character c : map.keySet()) {
            pq.offer(c);
        }
        while (!pq.isEmpty()) {
            Character c = pq.poll();
            for (int i = 0; i < map.get(c); i++) {
                res.append(c);
            }
        }
        return res.toString();
    }
}
