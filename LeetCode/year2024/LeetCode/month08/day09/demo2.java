package LeetCode.month08.day09;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/9 10:13
 */
public class demo2 {
    public int countWays(int[][] ranges) {
        int mod = 1000000007, res = 1 ;
        Arrays.sort(ranges, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(ranges[0]);
        for (int i = 1; i < ranges.length; i++) {
            int[] cur = ranges[i];
            int[] last = queue.getLast();
            if (cur[0] <= last[1]) {
                int[] remove = queue.removeLast();
                remove[1] = Math.max(remove[1], cur[1]);
                queue.addLast(remove);
            } else {
                queue.addLast(cur);
            }
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            res = (res * 2) % mod;
        }
        return res;
    }
}

