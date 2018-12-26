import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a, b) ->
                a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) :
                    a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        while (!priorityQueue.isEmpty()) {
            res.add(0, priorityQueue.poll().getKey());
        }

        return res;
    }
}
