package ca.umanitoba.leetcode.solution;

public class LC138CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next, random;

        Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
        node = head;
        while (node != null) {
            if (node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }
        node = head;
        Node result = head.next;
        while (node != null) {
            Node copy = node.next, next = copy.next;
            node.next = copy.next;
            copy.next = next == null ? null : next.next;
            node = next;
        }
        return result;
    }
}
