package month10.day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/coin-change/?envType=list&envId=hliQiQFH
 * @date 2023/10/18 12:24
 */
public class demo4 {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = max;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}

