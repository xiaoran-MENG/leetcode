import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
    public List<List<Integer>> threeSum(int[] nums) { // O(n^2)
        Arrays.sort(nums); // O(nlog(n))
        List<List<Integer>> triplets = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) { // O(n^2)
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) j++;
                else if (sum > 0) k--;
                else {
                    triplets.add(List.of(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[j] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return triplets;
    }
}
