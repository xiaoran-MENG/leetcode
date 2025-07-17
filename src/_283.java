public class _283 {
    public void moveZeroes(int[] nums) { // O(n)
        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
    }
}
