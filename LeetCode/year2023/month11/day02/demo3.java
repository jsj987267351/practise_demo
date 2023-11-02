package month11.day02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/2 11:56
 */
public class demo3 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

