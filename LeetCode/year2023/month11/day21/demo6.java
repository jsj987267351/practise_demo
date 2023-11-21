package month11.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/21 15:43
 */
public class demo6 {
    public int findTargetSumWays(int[] nums, int target) {
//        非负整数数组 nums
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target < 0) {
            target -= 2 * target;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int left = (sum + target) / 2;
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left];
    }
}

