package month07.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。
 * <p>
 * 给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
 * <p>
 * 袋子最初包含：
 * <p>
 * numOnes 件标记为 1 的物品。
 * numZeroes 件标记为 0 的物品。
 * numNegOnes 件标记为 -1 的物品。
 * 现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/k-items-with-the-maximum-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/5 14:20
 */
public class demo4 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
//        每日一题
        return k > numOnes + numZeros ? numOnes - (k - numOnes - numZeros) : Math.min(numOnes, k);
    }
}

