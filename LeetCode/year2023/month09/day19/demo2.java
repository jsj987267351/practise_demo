package month09.day19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/contiguous-sequence-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/19 12:28
 */
public class demo2 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

