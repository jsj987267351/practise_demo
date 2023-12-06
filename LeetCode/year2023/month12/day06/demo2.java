package month12.day06;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/6 13:03
 */
public class demo2 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            int diff = y - x;
            while (!deque.isEmpty() && x - deque.getFirst()[0] > k) {
                deque.pollFirst();
            }
            if (!deque.isEmpty()) {
                res = Math.max(res, x + y + deque.peekFirst()[1]);
            }
            while (!deque.isEmpty() && diff >= deque.peekLast()[1]) {
                deque.pollLast();
            }
            deque.addLast(new int[]{x, diff});
        }
        return res;
    }
}

