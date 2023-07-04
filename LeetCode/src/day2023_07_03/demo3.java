package day2023_07_03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/3 21:27
 */
public class demo3 {
    public int combinationSum4(int[] nums, int target) {
//        dp[i]，组成和为i的不同方式个数
        int[] dp = new int[target + 1];
//        组合总和为0的方式有一种即为什么也不装
        dp[0] = 1;

//        先遍历背包，因为求排列方式
        for (int i = 0; i <= target; i++) {
//            后遍历物品
            for (int j = 0; j < nums.length; j++) {
//                只有背包容量剩余足够的情况下才会累加
                if (i - nums[j] > 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}

