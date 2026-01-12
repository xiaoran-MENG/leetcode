package ca.umanitoba.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

import ca.umanitoba.leetcode.model.Node;

public class LC426ConvertBinarySearchTreeToSortedDoublyLinkedList {
    // O(n) | O(n) skewed tree | O(log(n)) balanced tree
    static class Recursive {
        private Node first = null, last = null;

        public Node treeToDoublyLists(Node root) {
            if (root == null) return null;
            convert(root);
            first.left = last;
            last.right = first;
            return first;
        }

        private void convert(Node root) {
            if (root == null) return;
            convert(root.left);
            if (first == null) first = root;
            if (last != null) {
                root.left = last;
                last.right = root;
            }
            last = root;
            convert(root.right);
        }
    }

    static class Iterative {
        // O(n) | O(n) skewed tree | O(log(n)) balanced tree bacase the stack holds log(n) nodes at most
        public Node treeToDoublyLists(Node root) {
            Node first = null, last = null;
            Deque<Node> stack = new ArrayDeque<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.addLast(root);
                    root = root.left;
                }
                root = stack.removeLast();
                if (first == null) first = root;
                if (last != null) {
                    root.left = last;
                    last.right = root;
                }
                last = root;
                root = root.right;
            }
            first.left = last;
            last.right = first;
            return first;
        }
    }
}
