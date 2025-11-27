package ca.umanitoba.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// D = target / min | O(N ^ D) | O(D)
// 每层最多有 N 种选择，递归树最深 target / min -> N x N x ...D 次... x N
public class _39 { 
    // 2 3 6 7
    static class Backtracking {
        public List<List<Integer>> solution(int[] candidates, int target) {
            // Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<>();
            backtrack(candidates, target, 0, new ArrayDeque<>(), result);
            return result;
        }

        private void backtrack(int[] candidates, int target, int start, Deque<Integer> path, List<List<Integer>> result) {
            if (target == 0) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                // 没有排序：continue 因为后面可能有小于 target 的数
                // 有排序：break 因为后面的数肯定都比 target 大，可以全部剪枝
                if (candidates[i] > target) continue; // breaks;
                path.addLast(candidates[i]);
                // 传入 i 因为当前数需要被下一个递归层重复使用
                backtrack(candidates, target - candidates[i], i, path, result);
                path.removeLast();
            }
        }
    }
}
