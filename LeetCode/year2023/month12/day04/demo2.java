package month12.day04;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/4 13:07
 */
public class demo2 {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] newHeights = new int[length + 2];
        for (int i = 0; i < length; i++) {
            newHeights[i + 1] = heights[i];
        }
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int right = 1; right < newHeights.length; right++) {
            while (newHeights[right] < newHeights[stack.peek()]) {
                int mid = stack.pop();
                int left = stack.peek();
                int height = newHeights[mid];
                int board = right - left - 1;
                res = Math.max(res, height * board);
            }
            stack.push(right);
        }
        return res;
    }
}

