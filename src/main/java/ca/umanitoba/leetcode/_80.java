package ca.umanitoba.leetcode;

public class _80 {
    // 1 1 2 2 2 3
    //         i
    //           j

    // i: 下个有效数字的位置
    // 0 ~ i - 1: 有效数字
    // i ~ j - 1: 无效数字(可以被覆盖)
    // j ~ N - 1: 未知数字
    // j: 当前正在被处理的数
    // IF 语句是有效数字的条件
    // 如果满足条件，把当前数字写入 i 的位置，i 和 j 移动
    // 否则，没有有效数字被写入, i 不动，i 移动
    static class TwoPointers {
        int solution(int[] nums) {
            int size = nums.length;
            if (size <= 2) return size;
            int i = 2, j = 2;
            while (j < size) { // O(N)
                if (nums[j] > nums[i - 2]) nums[i++] = nums[j];
                j++;
            }
            return i;
        }
    }
}
