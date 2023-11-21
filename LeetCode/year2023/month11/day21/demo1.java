package month11.day21;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/21 14:38
 */
public class demo1 {
    public int minDeletion(int[] nums) {
//        deleted代表已经删除的元素，那么 i - deleted 就代表该元素下标在新数组中的下标位置
        int deleted = 0, length = nums.length;
        for (int i = 0; i < length; i++) {
//            只有当偶数下标i ，nums[i] != nums[i + 1] 不满足时才删除
            if ((i - deleted) % 2 == 0 && i < length - 1 && nums[i] == nums[i + 1]) {
                deleted++;
            }
        }
        return (length - deleted) % 2 == 0 ? deleted : deleted + 1;
    }

    public static int minDeletion1(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int num : nums) {
//            栈的大下为偶数的话，那么下一个进来的元素的下标就是偶数，因为是从0开始的
            if (stack.size() % 2 == 0) {
                stack.push(num);
            } else if (stack.peek() != num) {
                stack.push(num);
            }
        }
//        最终结果要求返回偶数,此时stack里的数字就是最长美丽数组,res是要删除的数字
//        如果stack的长度为奇数的话，那么就要多删一个
        int res = nums.length - stack.size();
        return stack.size() % 2 == 0 ? res : res + 1;
    }
}

