package ca.umanitoba.leetcode;

import java.util.Arrays;

public class _14 {

    static class HorizontalScan {
        String solution(String[] strs) { // O(N x M^2) | O(1)
            String result = strs[0];
            for (String str : strs) { // O(N)
                if (str.isEmpty()) return "";
                while (str.indexOf(result) != 0) { // O(M^2)
                    result = result.substring(0, result.length() - 1);
                    if (result.isEmpty()) return "";
                }
            }
            return result;
        }
    }

    static class VerticalScan {
        String solution(String[] strs) { // O(M x N) | O(1)
            for (int c = 0; c < strs[0].length(); c++) { // O(M)
                char current = strs[0].charAt(c);
                for (String str : strs) { // O(N)
                    if (c >= str.length() || current != str.charAt(c))
                        return strs[0].substring(0, c);
                }
            }
            return strs[0];
        }
    }

    //      o  
    //    /   \
    //   o     o
    //  / \   / \
    // o   o o   o
    // N = 4
    // couquer = 3 = N - 1 = N - 1
    // T = couquer x T_couquer = O(N - 1) x O(M) = O(N x M)
    // S = stack height = O(log(N))
    static class DivideAndConquer {
        String solution(String[] strs) { // O(N x M) | O(log(N))
            return divide(strs, 0, strs.length - 1);
        }

        private String divide(String[] strs, int start, int end) {
            if (start == end) return strs[start];
            int mid = (start + end) >>> 1;
            String left = divide(strs, start, mid), right = divide(strs, mid + 1, end);
            return conquer(left, right);
        }

        private String conquer(String left, String right) { // O(M)
            int i = 0, min = Math.min(left.length(), right.length());
            while (i < min && left.charAt(i) == right.charAt(i)) i++;
            return left.substring(0, i); 
        }
    }

    static class BinarySearch {
        String solution(String[] strs) { // O(N x M x log(M)) | O(1)
            int high = 200;
            for (String str : strs) { // O(N)
                if (str.isEmpty()) return "";
                high = Math.min(high, str.length());
            }
            int low = 0;
            while (low < high) { // O(log(M))
                int mid = (low + high + 1) >>> 1;
                if (valid(strs, mid)) low = mid; // O(N x M)
                else high = mid - 1;
            }
            return strs[0].substring(0, low);
        }

        private boolean valid(String[] strs, int size) { // O(N x M)
            String prefix = strs[0].substring(0, size);
            for (String str : strs) // O(N)
                if (!str.startsWith(prefix)) return false; // O(M)
            return true;
        }
    }

    static class Sorting {
        String solution(String[] strs) { // O(N x log(N)) | O(1)
            Arrays.sort(strs); // O(N x log(N))
            String first = strs[0], last = strs[strs.length - 1];
            int i = 0, min = Math.min(first.length(), last.length());
            while (i < min && first.charAt(i) == last.charAt(i)) i++; // O(M)
            return first.substring(0, i);
        }
    }

    // Space worst
    // N words of size 26 with no common prefix
    // Trie size = 26 children x 26 height
    // O(N x M)
    static class Trie {
        static class Node {
            Node[] children = new Node[26];
            int size = 0;
            boolean end = false;
        }

        Node root = new Node();

        String solution(String[] strs) { // O(N x M) | O(N x M)
            for (String str : strs) { // O(N)
                if (str.isEmpty())
                    return "";
                add(str); // O(M)
            }

            var result = new StringBuilder();
            var cursor = root;
            while (!cursor.end && cursor.size == 1) { // O(M)
                for (int i = 0; i < 26; i++) {
                    if (cursor.children[i] != null) {
                        char c = (char) (i + 'a'); // Converts i to char
                        result.append(c);
                        cursor = cursor.children[i];
                        break;
                    }
                }
            }

            return result.toString();
        }

        private void add(String str) {
            Node cursor = root;
            for (char c : str.toCharArray()) { // O(M)
                int i = c - 'a'; // Converts char to i
                if (cursor.children[i] == null) {
                    cursor.children[i] = new Node();
                    cursor.size++;
                }
                cursor = cursor.children[i];
            }
            cursor.end = true;
        }
    }
}
