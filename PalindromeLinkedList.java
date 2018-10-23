/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode reverse = reverse(head);
        return isEquals(head, reverse);
    }

    private ListNode reverse(ListNode head) {
        ListNode reverseNode = null;
        while (head != null) {
            ListNode n = new ListNode(head.val);
            n.next = reverseNode;
            reverseNode = n;
            head = head.next;
        }
        return reverseNode;
    }

    private boolean isEquals(ListNode n1, ListNode n2) {
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1 == null && n2 == null;
    }
}
