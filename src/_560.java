import java.util.HashMap;
import java.util.Map;

// Space: O(n)
// Time: O(n)
public class _560 {
    // Have a running sum
    // Want a subarray to be equal to k
    // Use sum - k to check how many such subarrays previously exist
    // Requires a cache - map<prefix_sum, count>
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // Os(n)
        map.put(0, 1);
        int result = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) { // O(n)
            sum += nums[i];
            int prefixSum = sum - k;
            // Avoids listing all subarrays by tracking a running sum and caching {prefix sum - count} pairs
            // Reverse engineer subarray counts
            if (map.containsKey(prefixSum)) { // O(1)
                result += map.get(prefixSum); // O(1)
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1); // O(1)
        }
        return result;
    }

    private int prefixSum(int[] nums, int k) { // O(n^2)
        int n = nums.length;
        int count = 0;

        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                // Avoids recomputing subarray sums by using precomputed values
                int sum = prefixSum[end + 1] - prefixSum[start];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    private int naive(int[] nums, int k) { // O(n^3)
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
