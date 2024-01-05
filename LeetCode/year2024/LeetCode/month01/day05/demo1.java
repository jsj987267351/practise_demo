package LeetCode.month01.day05;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/5 12:30
 */
public class demo1 {
    public int[] canSeePersonsCount(int[] heights) {
        LinkedList<Integer> stack = new LinkedList<>();
        int length = heights.length;
        int[] res = new int[length];
        for (int i = length - 1; i >= 0; i--) {
//            如果当前元素比后面元素大的话，后面元素就会被当前元素挡住，前面的都会看不到，所以直接弹出
            while (!stack.isEmpty() && heights[i] >= stack.peek()) {
                stack.pop();
                res[i]++;
            }
//            如果栈内还有元素的话，那么当前栈顶的元素就是第一个比当前元素大的值，也可以看到，所以+1
            if (!stack.isEmpty()) {
                res[i]++;
            }
            stack.push(heights[i]);
        }
        return res;
    }
}

