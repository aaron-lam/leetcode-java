import java.util.Stack;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = toStack(l1);
        Stack<Integer> s2 = toStack(l2);
        ListNode res = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = carry;
            sum += (s1.isEmpty()) ? 0 : s1.pop();
            sum += (s2.isEmpty()) ? 0 : s2.pop();
            ListNode head = new ListNode(sum % 10);
            head.next = res;
            res = head;
            carry = sum / 10;
        }
        return res;
    }

    public Stack<Integer> toStack(ListNode node) {
        Stack<Integer> s = new Stack<>();
        while (node != null) {
            s.push(node.val);
            node = node.next;
        }
        return s;
    }
}
