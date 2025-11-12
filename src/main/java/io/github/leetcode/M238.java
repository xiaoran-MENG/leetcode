package io.github.leetcode;

public class M238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            result[i] = num;
            num *= nums[i]; // 下个元素左边的乘积
        }
        num = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= num; // result[i] 已经是 i 左边数字的乘积
            num *= nums[i]; // 下个元素右边的乘积
        }
        return result;
    }

    // 1 2 3 4
    // 1 1 2 6
    // 24 12 4 1
    // 24 12 8 6
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] prefix = new int[n];
//        prefix[0] = 1;
//        for (int i = 1; i < n; i++) {
//            prefix[i] = nums[i - 1] * prefix[i - 1];
//        }
//        int[] suffix = new int[n];
//        suffix[n - 1] = 1;
//        for (int i = n - 2; i >= 0; i--) {
//            suffix[i] = nums[i + 1] * suffix[i + 1];
//        }
//        for (int i = 0; i < n; i++) {
//            prefix[i] *= suffix[i];
//        }
//        return prefix;
//    }
}
