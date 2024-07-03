package LeetCode.month07.day03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/3 9:53
 */
public class demo4 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0], min = nums[0], max = nums[0], curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            curMin = Math.min(nums[i], curMin + nums[i]);
            max = Math.max(max, curMax);
            min = Math.min(min, curMin);
            sum += nums[i];
        }
        return max < 0 ? max : Math.max(max, sum - min);
    }
}

