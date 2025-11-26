package ca.umanitoba.leetcode;

import java.util.Arrays;

public class _16 {
    // -4 -1 1 2 | 1
    // i
    //     j
    //         k
    static class SortingAndTwoPointers {
        int solution(int[] nums, int target) { // O(N ^ 2) | O(1)
            Arrays.sort(nums); // O(N x log(N))
            int size = nums.length, result = nums[0] + nums[1] + nums[2];
            if (result >= target) return result;
            result = nums[size - 3] + nums[size - 2] + nums[size - 1];
            if (result <= target) return result;
            for (int i = 0; i < size - 2; i++) { // O(N ^ 2)
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int j = i + 1, k = size - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) return sum;
                    if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;
                    if (sum < target) j++;
                    else k--;
                }
            }
            return result;
        }
    }
}
