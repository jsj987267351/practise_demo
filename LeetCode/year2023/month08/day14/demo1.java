package month08.day14;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * @date 2023/8/14 15:45
 */
public class demo1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();
        int rowLength = intervals.length;
        int[][] temp = new int[rowLength + 1][2];
//        题目已经排过序了，所以直接插入到对应位置然后按照56题解法即可
//        这里的i是 intervals的索引，index是新数组的索引
        int i = 0, index = 0;
        while (i < rowLength && intervals[i][0] <= newInterval[0]) {
            temp[index++] = intervals[i++];
        }
//        此时的index就是newInterval应该放的位置
        temp[index++] = newInterval;
//        把后续的也加入新数组中
        while (i < rowLength) {
            temp[index++] = intervals[i++];
        }
        res.add(temp[0]);
        for (i = 1; i <= rowLength; i++) {
            int[] last = res.get(res.size() - 1);
            if (temp[i][0] <= last[1]) {
                last[1] = Math.max(last[1], temp[i][1]);
                res.remove(res.size() - 1);
                res.add(last);
            } else {
                res.add(temp[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

