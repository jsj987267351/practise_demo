package LeetCode.month06.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/10 16:36
 */
public class demo3 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        left[0] = 1;
        int[] right = new int[len];
        right[len - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}

