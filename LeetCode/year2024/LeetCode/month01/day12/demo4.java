package LeetCode.month01.day12;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/12 13:06
 */
public class demo4 {
    public int minimumMountainRemovals(int[] nums) {
        int length = nums.length;
        int[] leftUp = new int[length];
        int[] rightUp = new int[length];
        Arrays.fill(leftUp, 1);
        Arrays.fill(rightUp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    leftUp[i] = Math.max(leftUp[i], leftUp[j] + 1);
                }
            }
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    rightUp[i] = Math.max(rightUp[i], rightUp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 1; i < length - 1; i++) {
            if (leftUp[i] < 2) continue;
            if (rightUp[i] < 2) continue;
            res = Math.max(res, leftUp[i] + rightUp[i] - 1);
        }
        return length - res;
    }
}

