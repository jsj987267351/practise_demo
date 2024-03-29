package month07.day03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。 
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/coin-change-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/3 21:03
 */
public class demo2 {
    public int change(int amount, int[] coins) {
//        完全背包
//        dp[i]的含义，凑成i金额的方式
        int[] dp = new int[amount + 1];
//        凑成金额0的方式有一种，就是什么都不装
        dp[0] = 1;
//        先遍历物品，因为是求组合问题  如果是排列问题就要先遍历背包
//        因为求组合问题的话，与物品顺序是无关的，所以先遍历物品，把一个物品遍历完后在遍历第二个物品，就可以保证这两个物品的顺序唯一
//        而求排列问题的话，与顺序是相关的，所以先遍历背包，让每个背包容量都对物品进行遍历
        for (int i = 0; i < coins.length; i++) {
//            后遍历背包，正序遍历，因为完全背包是可以重复使用的
//            01背包倒序是因为每个数值只与当前值与左边值相关，所以在计算当前值时左边值不可以进行改动
//            而完全背包不同，他需要使用修改后的值
            for (int j = coins[i]; j <= amount; j++) {
//                与目标和那题一样，举例 容量为5  遇到数字1时 装满的方法就是dp[4]，因为 4的总方法每个加上1都是结果，这样遍历每个物品即可
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}

