package LeetCode.month08.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/1 9:22
 */
public class demo1 {
    public boolean validPartition(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[1] = nums[0] == nums[1];
        if (len == 2) {
            return dp[1];
        }
        if (nums[0] == nums[1] && nums[1] == nums[2] || (nums[0] + 1 == nums[1] && nums[1] + 1 == nums[2])) {
            dp[2] = true;
        }
        for (int i = 3; i < len; i++) {
            if (nums[i] == nums[i - 1] && dp[i - 2] ||
                    i > 3 && nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2] && dp[i - 3] ||
                    i > 3 && nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1 && dp[i - 3]) {
                dp[i] = true;
            }
        }
        return dp[len - 1];
    }
}

