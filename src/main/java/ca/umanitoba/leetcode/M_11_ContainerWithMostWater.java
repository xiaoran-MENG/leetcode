package ca.umanitoba.leetcode;

public class M_11_ContainerWithMostWater {
    public static class TwoPointers {
        public int solution(int[] height) {
            int result = 0, left = 0, right = height.length - 1;
            while (left < right) { // O(N)
                result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
                if (height[left] < height[right]) left++;
                else right--;
            }
            return result;
        }
    }
}
