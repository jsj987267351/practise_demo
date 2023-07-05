package month06.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/16 14:06
 */
public class demo1 {
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
//        dp[i]数组含义为凑成i元最少需要多少个平方数
        for (int i = 2; i < dp.length; i++) {
            dp[i] = max;
        }
//        初始为1，因为题目n>=1
        dp[1] = 1;
//        完全平方数从1开始遍历，最大直到目标值的一半即可。
//        先遍历物品
        for (int i = 1; i <= n / 2; i++) {
//            后遍历背包
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j - i * i] +1, dp[j]);
                }
            }
        }
        return dp[n] == max ? -1 : dp[n];
    }
}

