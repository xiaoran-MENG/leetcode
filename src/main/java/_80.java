public class _80 {
    // 0 0 2 3 3 3 3 3 3 5 6 6 6 6 7
    //                 i
    //                             j
    // 0 0 2 3 3 5 6 6 3 5 6 6 6 6 7
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
    // [0, i) 有效数
    // [i, j) 无效数（可被新的有效数覆盖）
    // [j, n) 待处理
}
