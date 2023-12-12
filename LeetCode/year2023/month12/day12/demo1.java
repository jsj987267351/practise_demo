package month12.day12;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/12 13:31
 */
public class demo1 {
    public int[] secondGreaterElement(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (!stack2.isEmpty() && nums[stack2.peek()] < num) {
                res[stack2.poll()] = num;
            }
//            用临时栈调整顺序，因为stack1弹出来的是正确顺序，如果直接压入stack2会导致与stack2栈顶比较的时候是逆序
//            要保证栈顶元素始终是后遍历到的元素
            LinkedList<Integer> temp = new LinkedList<>();
            while (!stack1.isEmpty() && nums[stack1.peek()] < num) {
                temp.push(stack1.poll());
            }
            while (!temp.isEmpty()){
                stack2.push(temp.poll());
            }
            stack1.push(i);
        }
        return res;
    }
}

