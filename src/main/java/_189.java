public class _189 {
    // 1 2 3 4 5 6 7 
    // k = 3
    // 7 6 5 | 4 3 2 1
    //         k
    // 5 6 7 | 1 2 3 1
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
