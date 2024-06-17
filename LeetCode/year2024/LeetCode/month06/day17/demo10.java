package LeetCode.month06.day17;

import java.util.LinkedList;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/17 14:49
 */
public class demo10 {
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < putIn.length; i++) {
            stack.push(putIn[i]);
            while (!stack.isEmpty() && stack.peek() == takeOut[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}

