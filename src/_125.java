public class _125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int start = 0, end = s.length() - 1;
        while (start < end) {
            char left = s.charAt(start), right = s.charAt(end);
            if (!Character.isLetterOrDigit(left)) start++;
            else if (!Character.isLetterOrDigit(right)) end--;
            else {
                if (Character.toLowerCase(left) != Character.toLowerCase(right)) return false;
                start++;
                end--;
            }
        }
        return true;
    }
}