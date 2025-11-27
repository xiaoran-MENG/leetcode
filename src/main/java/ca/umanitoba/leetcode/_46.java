package ca.umanitoba.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _46 {
    static class Backtracking { // O(N!) or O(N x N!) | O(n
        List<List<Integer>> solution(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(result, nums, new ArrayDeque<>(), new boolean[nums.length]);
            return result;
        }

        private void backtrack(List<List<Integer>> result, int[] nums, Deque<Integer> path, boolean[] used) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path)); // Copy O(N)
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                path.addLast(nums[i]);
                backtrack(result, nums, path, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
