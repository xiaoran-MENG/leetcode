package ca.umanitoba.leetcode;

public class _283 {
    public void solution(int[] nums) { // O(n)
        int i = 0, j = 0, size = nums.length;
        while (j < size) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
