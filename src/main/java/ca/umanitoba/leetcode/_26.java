package ca.umanitoba.leetcode;

public class _26 {
    // 0 0 1 1 1 2 2 3 3 4
    //         i
    //                   j
    // 0 1 2 3 4
    static class TwoPointers {
        int solution(int[] nums) {
            int i = 0, j = 0, size = nums.length;
            while (j < size) { // O(N)
                if (nums[j] != nums[i]) nums[++i] = nums[j];
                j++;
            }
            return i + 1;
        }
    }
}
