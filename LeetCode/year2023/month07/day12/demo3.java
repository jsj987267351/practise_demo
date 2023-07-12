package month07.day12;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/12 14:58
 */
public class demo3 {
    public int[] nextGreaterElements1(int[] nums) {
//        方法1：开辟新数组，长度为原先两倍，然后填入两份新数组通过线性实现环形
//        最后取该数组的前部分即可
        int length = nums.length;
        int[] res = new int[length * 2];
        int[] nums2 = new int[length * 2];

        Arrays.fill(res, -1);

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            nums2[i] = nums[i];
        }

        for (int i = length, j = 0; j < length; i++, j++) {
            nums2[i] = nums[j];
        }

        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] > nums2[stack.peek()]) {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    res[stack.pop()] = nums2[i];
                }
            }
            stack.push(i);
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = res[i];
        }
        return result;
    }


    public int[] nextGreaterElements2(int[] nums) {
//        方法2：通过取模实现循环
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < length * 2; i++) {
            int index = i % length;
            if (nums[index] > nums[stack.peek()]) {
                while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                    res[stack.pop()] = nums[index];
                }
            }
            stack.push(index);
        }
        return res;
    }

        public int[] nextGreaterElements(int[] nums) {
//        方法2：通过取模实现循环
            int length = nums.length;
            int[] res = new int[length];
            Arrays.fill(res, -1);

            Deque<Integer> stack = new LinkedList<>();
            stack.push(0);

            for (int i = 1; i < length * 2; i++) {
                if (nums[i % length] > nums[stack.peek() ]) {
                    while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                        res[stack.pop()] = nums[i % length];
                    }
                }
                stack.push(i %length);
            }
            return res;
        }
}

