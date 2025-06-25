public class _26 {
    // 1
    //   i
    //   j

    // 1 1
    //   i
    //     j

    // 1 2 2 5
    //       i
    //         j
    // 1 2 5 5
    public int removeDuplicates(int[] nums) { // T: O(n) + S: O(1)
        int i = 1, j = 1;
        while (j < nums.length) {
            if (nums[i - 1] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
