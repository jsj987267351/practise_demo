package LeetCode.month03.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/1 12:01
 */
public class demo {
    public boolean validPartition(int[] nums) {
        int length = nums.length;
//        dp[i]表示从头开始，以i结尾数组是否存在有效划分
        boolean[] dp = new boolean[length];
        if (nums[1] == nums[0]) dp[1] = true;
        if (length == 2) return dp[1];
        if (nums[2] == nums[1] && nums[1] == nums[0] || nums[2] == nums[1] + 1 && nums[1] == nums[0] + 1) dp[2] = true;
        for (int i = 3; i < length; i++) {
            if (dp[i - 2] && nums[i] == nums[i - 1]
                    || dp[i - 3] && (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2] || nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1)) {
                dp[i] = true;
            }
        }
        return dp[length - 1];
    }
}

