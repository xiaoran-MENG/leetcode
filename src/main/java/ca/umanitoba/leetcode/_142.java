package ca.umanitoba.leetcode;

public class _142 {
    // o -
    // o - o -
    public ListNode solution(ListNode head) { // O(n)
        ListNode runner = head, walker = head;
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) {
                runner = head;
                // runner and walker now have the same distance to the first node of cycle
                while (runner != walker) {
                    runner = runner.next;
                    walker = walker.next;
                }
                return runner;
            }
        }
        return null;
    }
}
