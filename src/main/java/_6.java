// P     I    N
// A   L S  I G
// Y A   H R
// P     I

// P     H
// A   S I
// Y  I  R
// P L   I G
// A     N
// rows = 5
// steps = 8 = (5 - 1) * 2
// sub steps = steps - 2 * row
// 2: A - S = 6 = 8 - 2 * 1
// 3: Y - I = 4 = 8 - 2 * 2
// 4: P - L = 2 = 8 - 2 * 3
public class _6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int n = s.length(), steps = (numRows - 1) * 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < n; j += steps) {
                result.append(s.charAt(j));
                int k = j + steps - 2 * i;
                if (i > 0 && i < numRows - 1 && k < n)
                    result.append(s.charAt(k));
            }
        }
        return result.toString();
    }
}
