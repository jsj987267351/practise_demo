package day42;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * @date 2023/5/14 19:27
 */
public class demo4 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        //按照左边界排序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        res.add(intervals[0]);
//        循环遍历，如果该数组的左边界小于list中最后一个元素的右边界，说明有重叠部分，那么将数组list中最后一个元素的右边界更改为原先有边界和该数组右边界的最大值
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = res.get(res.size() - 1);
            if (intervals[i][0] <= ints[1]) {
                ints[1] = Math.max(ints[1], intervals[i][1]);
                res.remove(res.size() - 1);
                res.add(ints);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

