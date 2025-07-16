public class _206 {
    public ListNode reverseList(ListNode head) { // O(n)
        // Base
        if (head == null || head.next == null) return head;
        ListNode result = reverseList(head.next); // Os(n)
        head.next.next = head;
        head.next = null;
        return result;
    }
}
