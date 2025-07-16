import java.util.HashSet;
import java.util.Set;

/**
 * Binary search - last occurrence
 */
public class _1026 {
    public int longestRepeatingSubstring(String s) { // O(n^2)
        int n = s.length(), i = 0, j = n - 1;
        while (i < j) {
            int k = i + (j - i + 1) / 2;
            if (repeating(s, k)) {
                i = k;
            } else {
                j = k - 1;
            }
        }
        return i;
    }

    private boolean repeating(String s, int k) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n - k + 1; i++) {
            String sub = s.substring(i, i + k);
            if (set.contains(sub)) {
                return true;
            }
            set.add(sub);
        }
        return false;
    }
}
