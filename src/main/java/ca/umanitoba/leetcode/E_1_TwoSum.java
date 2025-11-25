package ca.umanitoba.leetcode;

import java.util.HashMap;
import java.util.Map;

public class E_1_TwoSum {
    public int[] twoSum(int[] nums, int target) { // O(N) | O(N)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // O(N)
            int complement = target - nums[i];
            if (map.containsKey(complement)) // O(1)
                return new int[] { 
                    map.get(complement), // O(1)
                    i
                };
            map.put(nums[i], i); // O(1)
        }
        throw new RuntimeException("Solution not found");
    }
}
