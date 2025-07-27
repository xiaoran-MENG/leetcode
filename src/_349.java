import java.util.HashSet;
import java.util.Set;

// Time: O(n + m)
// Space: O(n + m)
public class _349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(); // Os(n)
        for (int i = 0; i < nums1.length; i++) { // O(n)
            set.add(nums1[i]);
        }
        Set<Integer> result = new HashSet<>(); // Os(m)
        for (int i = 0; i < nums2.length; i++) { // O(m)
            if (set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
