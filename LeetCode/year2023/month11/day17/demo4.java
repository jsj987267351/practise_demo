package month11.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/17 14:28
 */
public class demo4 {
    public long maxAlternatingSum(int[] nums) {
        int length = nums.length;
        long[] dp = new long[2];
//        dp[0]持有，dp[1]未持有
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - nums[i]);
            dp[1] = Math.max(dp[1], dp[0] + nums[i]);
        }
        return dp[1];
    }
}

