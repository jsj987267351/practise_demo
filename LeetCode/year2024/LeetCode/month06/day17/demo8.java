package LeetCode.month06.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/17 14:28
 */
public class demo8 {
    public long maxAlternatingSum(int[] nums) {
        long[] dp = new long[2];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            dp[0] = Math.max(dp[0], nums[i] + dp[1]);
            dp[1] = Math.max(dp[1], dp[0] - nums[i]);
        }
        return dp[0];
    }
}

