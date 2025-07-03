public class _42 {
    public int trap(int[] height) {
        int n = height.length, maxLeft = 0, maxRight = 0, i = 0, j = n - 1, result = 0;
        int[] left = new int[n], right = new int[n];
        
        while (i < n) { // O(n)
            left[i] = maxLeft;
            right[j] = maxRight;
            maxLeft = Math.max(maxLeft, height[i]);
            maxRight = Math.max(maxRight, height[j]);
            i++;
            j--;
        }

        for (int k = 0; k < n; k++) { // O(n)
            int water = Math.min(left[k], right[k]) - height[k];
            water = water > 0 ? water : 0;
            result += water;
        }

        return result;
    }
}
