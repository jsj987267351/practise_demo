package month10.day24;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/description/?envType=daily-question&envId=2023-10-24
 * @date 2023/10/24 12:03
 */
public class demo1 {
    int mod = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
//        首先特判，因为使用k个n个筛子，每个筛子的最大值为k，最小值为1 所以结果范围应该是[n,n*k]
        if (target < n || target > n * k) {
            return 0;
        }
//        dp[i]表示置总点数为i的方法个数
//        首先给使用一个筛子赋初值,使用一个筛子，那么[1,k]都有可能出现一次
        long[] dp = new long[k + 1];
        Arrays.fill(dp, 1);

//        截止不断更新使用筛子的数量
        for (int a = 2; a <= n; a++) {
//            创建一个新数组，与原dp一致，只不过因为使用筛子数量不同，所以新数组的范围也不同
            long[] new_dp = new long[a * k + 1];
//            开始遍历上一个筛子数组的有效范围
            for (int b = a - 1; b <= (a - 1) * k; b++) {
//                开始遍历当前筛子每种点数出现的情况
                for (int c = 1; c <= k; c++) {
                    new_dp[b + c] = (new_dp[b + c] + dp[b]) % mod;
                }
            }
            dp = new_dp;
        }
        return (int) dp[target];
    }

    public int numRollsToTarget1(int n, int m, int target) {
//        dp[i][j]表示使用前i个物品凑成容量为j的方案数
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
//        遍历物品
        for (int i = 1; i <= n; i++) {
//            遍历背包,背包剩余容量一定要大于当前物品的价值
            for (int j = i; j <= target; j++) {
//                遍历每个筛子的点数
                for (int k = 1; k <= m; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }

}

