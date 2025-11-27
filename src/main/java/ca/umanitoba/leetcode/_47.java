package ca.umanitoba.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class _47 {
    static class Backtracking { // O(N x log(N) + N x N!) | O(n
        List<List<Integer>> solution(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            backtrack(nums, new boolean[nums.length], new ArrayDeque<>(), result);
            return result;
        }

        private void backtrack(int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> result) {
            // 递归深度
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                // 跳过重复元素以避免生成重复的排列
                // 如果 nums[i] == nums[i-1] 且 nums[i-1] 未被使用 (!used[i-1]):
                //   - 说明我们在同一递归层级
                //   - 前一个相同的数已经被处理并跳过了
                //   - 使用当前的数会产生重复的排列
                // 如果 nums[i-1] 已被使用 (used[i-1] == true):
                //   - 它位于当前路径中（递归树中的父节点）
                //   - 使用当前的数会创建不同的路径，因此是允许的
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                path.addLast(nums[i]);
                backtrack(nums, used, path, result);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
