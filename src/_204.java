public class _204 {
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i < j) {
            int k = i + (j - i) / 2;
            if (isBadVersion(k)) {
                j = k;
            } else {
                i = k + 1;
            }
        }
        return i;
    }

    private boolean isBadVersion(int k) {
        return true;
    }
}
