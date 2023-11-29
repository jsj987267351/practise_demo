package month11.day29;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/29 17:10
 */
public class demo3 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> queue = new LinkedList<>();
        int rowLength = intervals.length;
        int[][] newIntervals = new int[rowLength + 1][2];
        int indexOld = 0, indexNew = 0;
        while (indexOld < rowLength && intervals[indexOld][0] <= newInterval[0]) {
            newIntervals[indexNew++] = intervals[indexOld++];
        }
        newIntervals[indexNew++] = newInterval;
        while (indexOld < rowLength) {
            newIntervals[indexNew++] = intervals[indexOld++];
        }
        queue.add(newIntervals[0]);
        for (int i = 1; i <= rowLength; i++) {
            int[] last = queue.getLast();
            int[] cur = newIntervals[i];
            if (last[1] >= cur[0]) {
                last[1] = Math.max(last[1], cur[1]);
                queue.removeLast();
                queue.addLast(last);
            } else {
                queue.addLast(cur);
            }
        }
        return queue.toArray(new int[queue.size()][]);
    }
}

