package month07.day23;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * https://leetcode.cn/problems/trapping-rain-water/
 * @date 2023/7/23 17:55
 */
public class demo1 {
    public int trap(int[] height) {
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        for (int i = 1; i < length - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < length - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }
}

