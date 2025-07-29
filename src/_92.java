public class _92 {
    // 1 2 3 4 5
    //   l
    //       r 

    // o 1 2 3 4 5
    //   l
    //           h

    // o 1 2 3 4 5 l = 1 r = 3
    //   |   |
    // l
    //         h
    //   s 

    // T: O(n)
    // S: O(n)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fake = new ListNode(0, head), low = fake;
        for (int i = 0; i < left - 1; i++) low = low.next;
        ListNode high = low;
        int count = right - left;
        for (int i = 0; i < count + 2; i++) high = high.next;
        ListNode start = low.next;
        low.next = reverse(start, count);
        start.next = high;
        return fake.next;
    }

    private ListNode reverse(ListNode head, int count) {
        if (count == 0) return head;
        ListNode result = reverse(head, count - 1);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
