package month12.day22;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/22 13:59
 */
public class demo1 {
    public int minimumMountainRemovals(int[] nums) {
        int length = nums.length;
//        dp[i]: 以下标i为尾节点的连续递增子序列的最大长度
        int[] dpPlus = new int[length];
        Arrays.fill(dpPlus, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpPlus[i] = Math.max(dpPlus[i], dpPlus[j] + 1);
                }
            }
        }
//        dp[i]: 以下标i为起点的最长连续递减子序列的长度
        int[] dpSub = new int[length];
        Arrays.fill(dpSub, 1);
        for (int i = length - 2; i >= 0; i--) {
            for (int j = length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dpSub[i] = Math.max(dpSub[i], dpSub[j] + 1);
                }
            }
        }
//        所以以i为山顶的最长山形数组的长度就是dpPlus[i] + dpSub[i] -1，因为两个都包括了i,结果是要找最长的,其中两头不能当山顶，并且两边都要有山才行
        int res = 0;
        for (int i = 1; i < length - 1; i++) {
//            左边没山
            if (dpPlus[i] < 2) continue;
//            右边没山
            if (dpSub[i] < 2) continue;
            res = Math.max(res, dpSub[i] + dpPlus[i] - 1);
        }
        return length - res;
    }
}

