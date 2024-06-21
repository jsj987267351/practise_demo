package LeetCode.month06.day21;


import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 10:42
 */
public class demo8 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int len = intervals.length;
        int[][] dp = new int[len + 1][2];
        int index = 0, newIndex = 0;
        while (index < len && intervals[index][0] <= newInterval[0]) {
            dp[newIndex++] = intervals[index++];
        }
        dp[newIndex++] = newInterval;
        while (index < len) {
            dp[newIndex++] = intervals[index++];
        }
        deque.addLast(dp[0]);
        for (int i = 1; i <= len; i++) {
            int[] cur = dp[i];
            int[] last = deque.getLast();
            if (cur[0] <= last[1]) {
                deque.removeLast();
                last[1] = Math.max(last[1], cur[1]);
                deque.addLast(last);
            } else {
                deque.add(cur);
            }
        }
        return deque.toArray(new int[deque.size()][]);
    }
}

