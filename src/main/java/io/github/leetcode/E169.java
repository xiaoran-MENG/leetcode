package io.github.leetcode;

// Boyer–Moore 投票算法
// 多数元素（出现次数 > n/2）在抵消过程中不可能被完全抵消掉。
// 即使被中途替换，最终它仍然会重新成为候选人并“赢回”主导权。
public class E169 {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = -1;
        for (int num : nums) {
            // 即使中途 count 变为 0（代表前一轮平票）
            // 下一次重新选候选人时，多数元素仍然有更多机会出现在后续
            if (count == 0) candidate = num;
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }
}
