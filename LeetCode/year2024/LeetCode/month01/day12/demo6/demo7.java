package LeetCode.month01.day12.demo6;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/12 13:25
 */
public class demo7 {
    public int[] canSeePersonsCount(int[] heights) {
        int length = heights.length;
        int[] res = new int[length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = length - 1; i >= 0; i--) {
            int cur = heights[i];
            while (!stack.isEmpty() && cur >= heights[stack.peek()]) {
                stack.pop();
                res[i]++;
            }
            if (!stack.isEmpty()){
                res[i]++;
            }
            stack.push(i);
        }
        return res;
    }
}

