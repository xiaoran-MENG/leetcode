import java.util.Arrays;

public class _410 {
    public int splitArray(int[] nums, int k) { // O(nlog(sum))
        int i = Arrays.stream(nums).max().getAsInt();
        int j = Arrays.stream(nums).sum();
        while (i < j) {
            int bucket = i + (j - i) / 2;
            if (canSplit(nums, k, bucket)) {
                j = bucket;
            } else {
                i = bucket + 1;
            }
        }
        return i;
    }

    private boolean canSplit(int[] nums, int k, int bucket) {
        int sum = 0, count = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > bucket) {
                sum = nums[i];
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }
}
