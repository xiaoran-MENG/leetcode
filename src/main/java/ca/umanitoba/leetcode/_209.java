package ca.umanitoba.leetcode;

public class _209 {
    static class SlidingWindow {
        public int solution(int target, int[] nums) { // O(n)
            int result = Integer.MAX_VALUE;
            int sum = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum >= target) {
                    result = Math.min(result, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }

    static class BinarySearch {
        public int solution(int target, int[] nums) {
            int low = 1, high = nums.length, result = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (valid(nums, target, mid)) {
                    result = mid;
                    high = mid - 1;
                } else low = mid + 1;
            }
            return result;
        }

        private boolean valid(int[] nums, int target, int size) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (i >= size) sum -= nums[i - size];
                if (sum >= target) return true;
            }
            return false;
        }
    }
}
