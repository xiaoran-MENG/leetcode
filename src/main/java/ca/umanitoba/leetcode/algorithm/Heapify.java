package ca.umanitoba.leetcode.algorithm;

// 7 3 5 1 6 4
// 0 1 2 3 4 5
//        7
//      3    5
//    1  6 4
// 1 6 4 是叶子节点，天然满足堆性质
// 6 / 2 - 1 = 3 - 1 = 2 -> 5 最后一个非叶子节点

// i = 2
// 7 3 4 1 6 5
// 0 1 2 3 4 5
//        7
//      3    4
//    1  6 5
// i = 5

// i = 5 [X]

// i = 1 | num = 3 | L = 1 | R = 6 [X]

// i = 0 | num = 7 | L = 3 | R = 5
// 3 7 4 1 6 5
// 0 1 2 3 4 5
//        3
//      7   4
//    1  6 5

// i = 1 | num = 7 | L = 1 | R = 6
// 3 1 4 7 6 5
// 0 1 2 3 4 5
//        3
//      1   4
//    7  6 5

// i = 3
public class Heapify {
    public void heapify(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) sift(nums, i);
    }

    private void sift(int[] nums, int i) {
        int j = i, left = 2 * i + 1, right = 2 * i + 2;
        // 保证left, right不越界
        // 5的right就越界了 2 * 2 + 2 = 6
        if (left < nums.length && nums[left] < nums[j]) j = left;
        if (right < nums.length && nums[right] < nums[j]) j = right;
        if (i == j) return;
        swap(nums, i, j);
        sift(nums, j);
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
