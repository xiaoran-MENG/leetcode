package ca.umanitoba.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
    // -2 -2 -2 -1 -1 0 0 1 1 2 2
    // i
    //                      j
    //                    k
    // -2 0 2 | -2 1 1
    static class SortingAndTwoPointers {
        List<List<Integer>> solution(int[] nums) {
            Arrays.sort(nums); // 固定了三个数的相对关系：nums[i] <= nums[j] <= nums[k]
            List<List<Integer>> result = new ArrayList<>();
            int size = nums.length;
            for (int i = 0; i < size - 2; i++) {
                // 因为排了序，nums[i] 如果等于 nums[i - 1], 可以保证 nums[i] 为首的三元组都处理过了
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int j = i + 1, k = size - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < 0) j++;
                    else if (sum > 0) k--;
                    else {
                        result.add(List.of(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) j++; // 此时 nums[j - 1] = nums[j] 或 j 没动
                        while (j < k && nums[k] == nums[k - 1]) k--; // 此时 nums[k + 1] = nums[k] 或 k 没动
                        j++;
                        k--;
                    }
                }
            }
            return result;
        }
    }
}
