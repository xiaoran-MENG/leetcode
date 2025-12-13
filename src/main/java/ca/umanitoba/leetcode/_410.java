package ca.umanitoba.leetcode;

public class _410 {
    // Binary search - first occurrence
    public int solution(int[] nums, int k) {
        int low = max(nums);
        int high = sum(nums);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (valid(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean valid(int[] nums, int k, int size) {
        int count = 1, sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > size) {
                count++;
                if (count > k) { // The window is too small
                    return false;
                }
                sum = num;
            }
        }
        return true;
        // count can be < k
        // [1 2] [1 2] [1] | k = 4 count = 3 size = 3
        // [1] [2] [1 2] [1] | count = 4
        // Can split existing subarrays to increase count to k
        // This means the window is valid but could be shrunk
        // Because we are looking for the smallest window
    }

    private int max(int[] nums) {
        int result = nums[0];
        for (int num : nums) {
            result = Math.max(result, num);
        }
        return result;
    }

    private int sum(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }
}
