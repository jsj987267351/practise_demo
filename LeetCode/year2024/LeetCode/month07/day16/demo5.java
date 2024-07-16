package LeetCode.month07.day16;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/16 10:32
 */
public class demo5 {
    public int minimumMountainRemovals(int[] nums) {
        int len = nums.length;
        int[] dpLeft = new int[len];
        Arrays.fill(dpLeft,1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpLeft[i] = Math.max(dpLeft[i], dpLeft[j] + 1);
                }
            }
        }
        int[] dpRight = new int[len];
        Arrays.fill(dpRight,1);
        for (int i = len - 2; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dpRight[i] = Math.max(dpRight[i], dpRight[j] + 1);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int mid = 1; mid < len - 1; mid++) {
            if (dpLeft[mid] < 2) continue;
            if (dpRight[mid] < 2) continue;
            int cur = dpLeft[mid] + dpRight[mid] - 1;
            res = Math.min(res, len - cur);
        }
        return res;
    }
}

