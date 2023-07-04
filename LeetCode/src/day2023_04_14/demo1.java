package day2023_04_14;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/next-greater-element-i/
 * @date 2023/4/14 14:19
 */
public class demo1 {
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    ints[i] = findNextMax(nums2, j);
                    break;
                }
            }
        }
        return ints;
    }

    public int findNextMax(int[] num, int k) {
        int temp = num[k];
        for (int i = k + 1; i < num.length; i++) {
            if (num[i] > temp) {
                return num[i];
            }
        }
        return -1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] result = new int[length];
        Map<Integer, Integer> map = findNextMax2(nums2);
        for (int i = 0; i < length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;

    }

    public Map<Integer, Integer> findNextMax2(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = num.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= num[i]) {
                stack.pop();
            }

            map.put(num[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(num[i]);
        }
        return map;
    }
}

