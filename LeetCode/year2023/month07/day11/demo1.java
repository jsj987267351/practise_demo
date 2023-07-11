package month07.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 一个下标从 0开始的数组的 交替和定义为 偶数下标处元素之 和减去 奇数下标处元素之 和。
 * <p>
 * 比方说，数组[4,2,5,3]的交替和为(4 + 5) - (2 + 3) = 4。
 * 给你一个数组nums，请你返回nums中任意子序列的最大交替和（子序列的下标 重新从 0 开始编号）。
 * <p>
 * 一个数组的 子序列是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。比方说，[2,7,4]是[4,2,3,7,2,1,4]的一个子序列（加粗元素），但是[2,4,2] 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-alternating-subsequence-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/11 13:16
 */
public class demo1 {
    public long maxAlternatingSum(int[] nums) {
        int length = nums.length;
        long[] dp = new long[2];
//        dp[0]表示持有股票  dp[1]表示不持有股票
//        可以理解为初始我们身上就有一张价值nums[0]的股票
//        dp[0]表示这张股票我们没有卖出去，还放在身上，所以资金为0
//        dp[1]表示这张股票卖了出去，所以我们身上有这张股票卖出去的钱
        dp[1] = nums[0];
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
//            持有股票有两种可能，前一天也持有，也可能前一天不持有，二者取最大值
//            前一天不持有的话，今天持有，就需要付出今天股票的价格来购买今天的股票
            dp[0] = Math.max(dp[0], dp[1] - nums[i]);
//            同理
            dp[1] = Math.max(dp[1], dp[0] + nums[i]);
        }
//        最后一定是不持有股票，将股票卖出去后身上所剩下的钱最多
        return dp[1];
    }
}

