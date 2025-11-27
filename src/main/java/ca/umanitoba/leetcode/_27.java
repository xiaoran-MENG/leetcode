package ca.umanitoba.leetcode;

public class _27 {
    static class TwoPointer {
        int solution(int[] nums, int val) {
            int i = 0, j = 0;
            while (j < nums.length) { // O(N)
                if (nums[j] != val) nums[i++] = nums[j];
                j++;
            }
            return i;
        }
    }
}
