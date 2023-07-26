package month07.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * https://leetcode.cn/problems/chou-shu-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @date 2023/7/26 14:27
 */
public class demo2 {
    public int nthUglyNumber(int n) {
//        丑数由另一个丑数成2，3，5得来，然后dp数组中存放的是所有丑数，所以求出丑数排列即可
//        dp[i]表示第i个丑数
        int[] dp = new int[n + 1];
//        第1个丑数是1，初始化
        dp[1] = 1;
//        三个的下标，初始都在第一个丑数下标上，下标对应的数字代表着 该数字乘对应的丑数乘数得到的最小丑数
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
//            求出当前各自下标的下一个丑数
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
//            最小的放入
            dp[i] = Math.min(Math.min(num2, num3), num5);
//            哪个丑数对应的数字加入了数组，那么该丑数的下标也要后移，避免重复计算
//            也有可能同时移动多个，因为最小值可能相同
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}

