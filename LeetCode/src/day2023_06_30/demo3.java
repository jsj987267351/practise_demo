package day2023_06_30;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/6/30 16:00
 */
public class demo3 {
//    01背包问题
//    解题思路，只要物品种能找到总和为sum的一半的话，说明可以分割。因为另一半一定也是sum的一半
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
//        如果总和为奇数的话，那么肯定不能分割
        if (sum%2 ==1){
            return false;
        }
//        确定背包容量为总和的一半
        int target = sum/2;
//        确定dp数组,dp[i]的含义为背包容量为i时最大能放多少物品的价值
        int[] dp = new int[target + 1];

//        先遍历物品
        for (int i = 0; i < length; i++) {
//            倒序遍历背包,结束条件为 j >=nums[i] 是因为如果容量不足就没必要继续遍历了
            for (int j = target; j >=nums[i] ; j--) {
                dp[j] = Math.max(dp[j] , dp[j -nums[i]] + nums[i]);
            }
//        剪枝，提前判断
            if (dp[target] == target){
                return true;
            }
        }
        return dp[target] == target;
    }
}

