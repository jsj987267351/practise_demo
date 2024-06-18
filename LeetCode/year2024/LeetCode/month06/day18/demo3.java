package LeetCode.month06.day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/18 10:07
 */
public class demo3 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}

