package month09.day30;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/30 16:52
 */
public class demo3 {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        for (int i = 1; i < len - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int left = leftMax[i];
            int right = rightMax[i];
            int min = Math.min(left, right);
            if (min > height[i]) {
                res += min - height[i];
            }
        }
        return res;
    }
}

