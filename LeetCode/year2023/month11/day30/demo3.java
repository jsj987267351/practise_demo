package month11.day30;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/30 12:13
 */
public class demo3 {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
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

