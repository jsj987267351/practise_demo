package day2023_06_30;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 * <p>
 * https://leetcode.cn/problems/integer-break/
 * @date 2023/6/30 13:04
 */
public class demo1 {
    public int integerBreak(int n) {
//        dp[i]含义，拆分i所能获得的乘积最大值
        int[] dp = new int[n + 1];
//        初始化0和1无意义，所以不用赋初始值
        dp[2] = 1;
//        从3开始遍历
        for (int i = 3; i <= n; i++) {
//            从1开始拆分，截止条件为i/2即可，因为后续都是颠倒重复的拆分了。 或者为i-j也可以
            for (int j = 1; j <= i / 2; j++) {
//                第二个max是找到拆成两个数和拆成2个数字以上的最大乘机
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}

