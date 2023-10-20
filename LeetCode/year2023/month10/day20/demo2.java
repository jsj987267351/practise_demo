package month10.day20;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/merge-intervals/?envType=list&envId=hliQiQFH
 * @date 2023/10/20 14:42
 */
public class demo2 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> queue = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        queue.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = queue.getLast();
            int[] cur = intervals[i];
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
                queue.removeLast();
                queue.add(last);
            } else {
                queue.add(cur);
            }
        }
        return queue.toArray(new int[queue.size()][]);
    }
}

