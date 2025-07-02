public class _11 {
    public int maxArea(int[] height) {
        int n = height.length, i = 0, j = n - 1, result = Integer.MIN_VALUE;
        while (i < j) { // O(n)
            result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return result;
    }
}
