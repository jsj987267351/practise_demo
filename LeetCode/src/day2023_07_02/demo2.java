package day2023_07_02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/2 18:11
 */
public class demo2 {
    public int findTargetSumWays(int[] nums, int target) {
//        解题思路：01背包，求两个背包使两个背包的差为 target 即可
//        推导公式，设左背包和为left，右背包和为right，总和为sum
//        即有:left  + right = sum   left - right = target
//        right = sum - left   left - (sum - left) = target  left = (target + sum)/2
//        即题目转换成将左背包容量为 (target + sum)/2 装满有几种方法
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
//        target取正，因为这里默认left为正数和
        if (target < 0) {
            target -= 2 * target;
        }
//        因为如果 target + sum 为奇数的话，那么左边总和就不是整除数，代表无解
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int left = (target + sum) / 2;
//        dp[i]含义为，装满容量为i的背包有多少种方法
        int[] dp = new int[left + 1];
//        装满容量为0的方法，刚开始直接不装就可以
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >=nums[i] ; j--) {
//                举例，总和为5 当前值为2，那么装满背包为5的方法和就可以加上dp[3]，因为dp[3]代表装满3的方法，在3的基础上加上2就装满5了
                dp[j]+=dp[j - nums[i]];
            }
        }
        return dp[left];
    }
}

