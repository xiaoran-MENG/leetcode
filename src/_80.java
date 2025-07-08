public class _80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int i = 2, j = 2;
        while (j < n) {
            if (nums[j] != nums[i - 2])
                nums[i++] = nums[j];
            j++;
        }
        return i;
    }
}
