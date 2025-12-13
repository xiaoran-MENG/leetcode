package ca.umanitoba.leetcode;

public class _278 {
    // | good | bad |
    // Binary search - first occurrence
    public int solution(int n) { // O(log(n))
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
