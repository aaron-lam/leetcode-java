public class DesignLinkedList {

    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    public DesignLinkedList() {

    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node prev = head;
        head = new Node(val);
        head.next = prev;
        size += 1;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        size += 1;
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else {
            size += 1;
            Node cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            Node node = new Node(val);
            node.next = cur.next;
            cur.next = node;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        size -= 1;
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }
}
