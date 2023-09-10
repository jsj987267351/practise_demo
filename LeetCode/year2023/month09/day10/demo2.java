package month09.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/10 12:37
 */
public class demo2 {
    int temp = 1000000007;

    public int waysToChange(int n) {
        int[] coins = {25, 10, 5, 1};
        int[] dp = new int[n + 1];
        dp[0] = 1;
//        dp[i]表示组成总价为i共有多少种方法
//        完全背包问题，先遍历物品，在遍历背包
        for (int i = 0; i < 4; i++) {
//            背包容量最少也要能够装下当前物品还是遍历
            for (int j = coins[i]; j < n + 1; j++) {
//                组成方法为前一种组成方法加上去掉当前硬币的组成方法，因为去掉当前硬币的方法总数只需要加上当前硬币就可以组成当前总数
                dp[j] = (dp[j] + dp[j - coins[i]]) % temp;
            }
        }
        return dp[n];
    }
}

