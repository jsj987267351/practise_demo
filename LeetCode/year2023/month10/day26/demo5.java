package month10.day26;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/26 11:53
 */
public class demo5 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] res = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        help(nums2, map);
        for (int i = 0; i < length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public void help(int[] nums2, Map<Integer, Integer> map) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty() || nums2[i] < stack.peek()) {
                stack.add(nums2[i]);
            } else {
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    map.put(stack.pop(), nums2[i]);
                }
                stack.add(nums2[i]);
            }
        }
    }
}

