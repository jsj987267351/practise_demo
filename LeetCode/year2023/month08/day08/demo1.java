package month08.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 * <p>
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/8/8 14:38
 */
public class demo1 {
    public int maxAbsoluteSum(int[] nums) {
//        找到连续的最大值与最小值，然后比较绝对值即可
        int length = nums.length;
        int[] dpMax = new int[length];
        int[] dpMin = new int[length];
        dpMax[0] = dpMin[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (dpMax[i - 1] > 0) {
                dpMax[i] = dpMax[i - 1] + nums[i];
            } else {
                dpMax[i] = nums[i];
            }
            if (dpMin[i - 1] > 0) {
                dpMin[i] = nums[i];
            } else {
                dpMin[i] = dpMin[i - 1] + nums[i];
            }
        }
        int max = dpMax[0], min = dpMin[0];
        for (int i = 0; i < length; i++) {
            max = Math.max(max, dpMax[i]);
            min = Math.min(min, dpMin[i]);
        }

        min = Math.abs(min);
        return max > min ? max : min;
    }

}

