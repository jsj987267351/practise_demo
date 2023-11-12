package month11.day12;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/12 15:04
 */
public class demo4 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0, right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < right) {
                res++;
                right = Math.min(right, intervals[i][1]);
            } else {
                right = intervals[i][1];
            }
        }
        return res;
    }
}

