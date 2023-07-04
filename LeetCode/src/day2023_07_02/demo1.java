package day2023_07_02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/last-stone-weight-ii/
 * @date 2023/7/2 17:53
 */
public class demo1 {
    public int lastStoneWeightII(int[] stones) {
//        解题思路，01背包解法，背包的容量为总重量的一半，尽量把他凑满
//        然后背包剩下的石头就是另一堆，这样两堆的差值一定最小
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
//        这时已经尽量把容量为 target 装满了，此时求两个石堆的差值即可
//        注意，因为除法为向下取证，所以剩下的石头总重量一定大于背包中的重量
        return sum - 2 * dp[target];
    }
}

