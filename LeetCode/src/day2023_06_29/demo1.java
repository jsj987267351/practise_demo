package day2023_06_29;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/29 12:55
 */
public class demo1 {
    public int eraseOverlapIntervals(int[][] intervals) {
//        按照左区间升序
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
//        记录结果总数
        int count = 0;
//        右区间
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < right) {
//                发生重叠，总数+1,同时更新right,更新right的含义是删除右边界长的那个区间
                count++;
                right = Math.min(right, intervals[i][1]);
            } else {
//                没有重叠的话直接更新右区间
                right = intervals[i][1];
            }
        }
        return count;
    }
}

