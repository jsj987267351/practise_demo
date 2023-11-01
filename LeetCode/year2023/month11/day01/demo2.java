package month11.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/1 13:14
 */
public class demo2 {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if (length < 2) {
            return 0;
        }
        int[] dp = new int[length + 1];
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[length];
    }
}

