package month03.day17;


public class demo2 {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * https://leetcode.cn/problems/maximum-subarray/
     */
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > dp[max]){
                max = i;
            }
        }
        return dp[max];


    }
}
