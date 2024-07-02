package LeetCode.month07.day02;

import java.util.ArrayDeque;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/2 10:12
 */
public class demo5 {
    public int largestRectangleArea(int[] heights) {
        int res = 0, len = heights.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] newHeight = new int[len + 2];
        System.arraycopy(heights, 0, newHeight, 1, len);
        stack.push(0);
        for (int i = 1; i < len + 2; i++) {
            while (newHeight[stack.peek()] > newHeight[i]) {
                int mid = stack.pop();
                int left = stack.peek();
                res = Math.max(res, newHeight[mid] * (i - left - 1));
            }
            stack.push(i);
        }
        return res;
    }
}

