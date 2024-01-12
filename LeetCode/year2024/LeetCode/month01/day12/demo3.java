package LeetCode.month01.day12;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/12 12:59
 */
public class demo3 {
    public int[] secondGreaterElement(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int cur = nums[i];
            while (!stack2.isEmpty() && cur > nums[stack2.peek()]) {
                res[stack2.pop()] = cur;
            }
            LinkedList<Integer> temp = new LinkedList<>();
            while (!stack1.isEmpty() && cur > nums[stack1.peek()]) {
                temp.push(stack1.pop());
            }
            stack1.push(i);
            while (!temp.isEmpty()) {
                stack2.push(temp.pop());
            }
        }
        return res;
    }
}

