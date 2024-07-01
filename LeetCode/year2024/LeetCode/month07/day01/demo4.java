package LeetCode.month07.day01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/1 9:58
 */
public class demo4 {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length * 2; i++) {
            int index = i % length;
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                res[stack.pop()] = nums[index];
            }
            stack.push(index);
        }
        return res;
    }
}

