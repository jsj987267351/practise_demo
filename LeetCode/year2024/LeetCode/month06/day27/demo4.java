package LeetCode.month06.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/27 9:56
 */
public class demo4 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target < 0) {
            target -= 2 * target;
        }
        if ((sum + target) % 2 != 0) return 0;
        int dpTarget = (sum + target) / 2;
        int[] dp = new int[dpTarget + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dpTarget; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[dpTarget];
    }
}

