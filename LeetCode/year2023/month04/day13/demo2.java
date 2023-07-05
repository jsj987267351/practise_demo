package month04.day13;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/min-cost-climbing-stairs
 * @date 2023/4/13 20:42
 */
public class demo2 {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] result = new int[length + 1];
        result[0] = 0;
        result[1] = 0;
        for (int i = 2; i < result.length; i++) {
            result[i] = Math.min(result[i - 1] + cost[i - 1], result[i - 2] + cost[i - 2]);
        }
        return result[length];
    }
}

