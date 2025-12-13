package ca.umanitoba.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _300 {
    // Binary search - first occurrence

    public int solution(int[] nums) {
        int size = nums.length;
        List<Integer> sorted = new ArrayList<>();
        sorted.add(nums[0]);
        for (int i = 1; i < size; i++) {
            if (nums[i] > sorted.get(sorted.size() - 1)) {
                sorted.add(nums[i]);
            } else {
                int start = 0, end = sorted.size() - 1;
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    // 4 10 4 3 8 9
                    // 4 10 | 4
                    // i
                    //   j
                    // m
                    // sorted.get(mid) > nums[i]
                    //   i
                    //   j
                    // 4 4
                    // sorted.get(mid) >= nums[i]
                    // i
                    // j
                    // 4 10
                    if (sorted.get(mid) >= nums[i]) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                sorted.set(start, nums[i]);
            }
        }
        return sorted.size();
    }
}
