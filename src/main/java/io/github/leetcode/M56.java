package io.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class M56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
        int[] current = intervals[0];
        for (int[] interval : intervals) {
            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                result.add(current);
                current = interval;
            }
        }
        // 最后一个区间没有在循环里添加
        result.add(current);
        return result.toArray(new int[0][]);
    }
}
