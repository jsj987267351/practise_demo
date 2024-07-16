package LeetCode.month07.day16;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/16 9:59
 */
public class demo3 {
    public int[] secondGreaterElement(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack2.isEmpty() && nums[i] > nums[stack2.peek()]) {
                res[stack2.pop()] = nums[i];
            }
            LinkedList<Integer> tmp = new LinkedList<>();
            while (!stack1.isEmpty() && nums[i] > nums[stack1.peek()]) {
                tmp.push(stack1.poll());
            }
            while (!tmp.isEmpty()) {
                stack2.push(tmp.pop());
            }
            stack1.push(i);
        }
        return res;
    }
}

