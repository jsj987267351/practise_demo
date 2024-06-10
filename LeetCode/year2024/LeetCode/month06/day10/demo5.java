package LeetCode.month06.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/10 16:58
 */
public class demo5 {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int curHeight = Math.min(left[i], right[i]);
            if (curHeight <= height[i]) {
                continue;
            }
            res += curHeight - height[i];
        }
        return res;
    }
}

