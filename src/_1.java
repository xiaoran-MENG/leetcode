import java.util.HashMap;
import java.util.Map;

public class _1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Os(n)
        for (int i = 0; i < nums.length; i++) { // O(n)
            int complement = target - nums[i];
            if (map.containsKey(complement)) // O(1)
                return new int[] { map.get(complement), i };
            map.put(nums[i], i); // O(1)
        }
        throw new RuntimeException("Solution not found");
    }
}
