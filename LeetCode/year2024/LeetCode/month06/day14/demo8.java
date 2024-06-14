package LeetCode.month06.day14;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/14 14:58
 */
public class demo8 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->a[0] - b[0]);
        int res = 0,right = intervals[0][1];
        for (int i = 1; i <intervals.length ; i++) {
            int[] cur = intervals[i];
            if (cur[0] < right){
                res++;
                right = Math.min(right,cur[1]);
            }else {
                right = cur[1];
            }
        }
        return res;
    }
}

