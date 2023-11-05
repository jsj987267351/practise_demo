package month11.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/5 17:49
 */
public class demo6 {
    public int trap(int[] height) {
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        int res = 0;
        for (int i = 1; i < length - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 1; i < length - 1; i++) {
            int left = leftMax[i];
            int right = rightMax[i];
            int min = Math.min(left, right);
            if (height[i] < min) {
                res += min - height[i];
            }
        }
        return res;
    }
}

