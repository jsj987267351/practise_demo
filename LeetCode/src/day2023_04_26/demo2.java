package day2023_04_26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * @date 2023/4/26 17:16
 */
public class demo2 {
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int temp = (j - i) * Integer.min(height[i], height[j]);
            if (temp > result) {
                result = temp;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}

