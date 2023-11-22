package month11.day22;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/22 13:33
 */
public class demo2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}

