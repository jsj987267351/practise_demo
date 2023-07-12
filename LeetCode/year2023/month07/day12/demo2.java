package month07.day12;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/12 14:47
 */
public class demo2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] res = new int[length];
//        map中存储了nums2 中每一个元素的下一个更大值
        Map<Integer, Integer> map = help(nums2);

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public Map<Integer, Integer> help(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > stack.peek()){
                while (!stack.isEmpty() && nums[i] > stack.peek()){
                    map.put(stack.pop(),nums[i]);
                }
            }
            stack.push(nums[i]);
        }
        return map;
    }
}

