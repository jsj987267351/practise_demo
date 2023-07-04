package day2023_04_14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @date 2023/4/14 14:56
 */
public class demo3 {
    public int maxSubArray1(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = result[0];
        for (int i = 1; i < nums.length; i++) {
            if (result[i - 1] < 0) {
                result[i] = nums[i];
            } else {
                result[i] = result[i - 1] + nums[i];
            }
            if (result[i] > max) {
                max = result[i];
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] < 0 ? nums[i] : nums[i - 1] + nums[i];
            max = Math.max(max,nums[i]);
        }
        return max;
    }
}

