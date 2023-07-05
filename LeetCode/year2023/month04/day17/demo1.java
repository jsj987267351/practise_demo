package month04.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
 * <p>
 * 链接：https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * @date 2023/4/17 12:04
 */
public class demo1 {
    public int numWays(int n) {
        if (n == 0 || n ==1) {
            return 1;
        }
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i < n+1; i++) {
            result[i] = (result[i - 1] + result[i - 2])%1000000007;
        }
        return result[n];
    }
}

