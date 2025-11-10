package io.github.leetcode;

// 荷兰国旗问题
// [0 L-1] = 0
// [L i-1] = 1
// [i R] = ?
// [R+1 n-1] = 2
// 右边换过来的数字是没处理过的， 所以i不动
// 左边换过来的数字是处理过的， 所以i右移
// 2 0 1 -> 1 0 2 -> 1 0 2 -> 0 1 2
// i        i          i          i
// L   R    L R      L R        R
// 0 2 1 -> 0 2 1 -> 0 1 2 -> 0 1 2
// i          i        i          i
// L   R      L R      R        R
public class M75 {
    public void sortColors(int[] nums) {
        int n = nums.length, i = 0, left = 0, right = n - 1;
        while (i <= right) {
            if (nums[i] == 2) swap(nums, i, right--);
            else {
                if (nums[i] == 0) swap(nums, i, left++);
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}