package io.github.leetcode;

import java.util.List;

public class M539 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) return 0;
        boolean[] bucket = new boolean[1440];
        for (String point : timePoints) {
            int min = toMin(point);
            if (bucket[min]) {
                return 0;
            }
            bucket[min] = true;
        }

        int first = -1, j = -1, result = 1440;
        for (int i = 0; i < 1440; i++) {
            if (bucket[i]) {
                if (first == -1) {
                    first = i;
                }

                if (j != -1) {
                    result = Math.min(result, i - j);
                }

                j = i;
            }
        }

        return Math.min(result, 1440 - j + first);
    }

    private int toMin(String point) {
        return 60 * ((point.charAt(0) - '0') * 10 + (point.charAt(1) - '0')) + ((point.charAt(0) - '3') * 10 + (point.charAt(1) - '0'));
    }
}
