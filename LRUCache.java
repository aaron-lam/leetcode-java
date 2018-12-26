import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> cache;
    private int count;
    private int capacity;
    private Node head;
    private Node tail;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    private void add(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(Node node) {
        this.remove(node);
        this.add(node);
    }

    private Node popTail() {
        Node res = tail.prev;
        this.remove(res);
        return res;
    }

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.count = 0;
        this.capacity = capacity;

        head = new Node();
        head.prev = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.add(newNode);
            count += 1;

            if (count > capacity) {
                Node tail = this.popTail();
                this.cache.remove(tail.key);
                count -= 1;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}
