package LeetCode.month07.day04;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/4 9:23
 */
public class demo1 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for (int[] point : points) {
            int xj = point[0], yj = point[1];
            while (!stack.isEmpty() && xj - stack.getFirst()[0] > k) {
                stack.removeFirst();
            }
            if (!stack.isEmpty()) {
                int[] first = stack.getFirst();
                res = Math.max(res, xj + yj + first[1]);
            }
            while (!stack.isEmpty() && stack.getLast()[1] < yj - xj) {
                stack.removeLast();
            }
            stack.addLast(new int[]{xj, yj - xj});
        }
        return res;
    }
}

