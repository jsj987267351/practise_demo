package day23;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/running-sum-of-1d-array
 */
public class demo1 {
    public int[] runningSum1(int[] nums) {
        int temp = nums[0];
        int temp2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp2 = nums[i];
            nums[i] += temp;
            temp += temp2;
        }
        return nums;
    }

    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i]+=nums[i-1];
        }
        return nums;
    }
}

