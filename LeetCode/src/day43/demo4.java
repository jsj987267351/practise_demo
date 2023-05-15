package day43;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的
 * 链接：https://leetcode.cn/problems/coin-change
 * @date 2023/5/15 18:41
 */
public class demo4 {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
//        dp[i] 代表的是凑成i金额所需要的最少硬币个数为 dp[i]
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}

