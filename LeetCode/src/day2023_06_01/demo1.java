package day2023_06_01;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/1 18:54
 */
public class demo1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
//        单调递增栈
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < length; i++) {
//               只要栈顶的下标的元素比加入站的元素小就弹出,并且记录
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}

