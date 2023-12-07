package month12.day07;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/7 14:54
 */
public class demo6 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int index2 = 1, index3 = 1, index5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[index2] * 2;
            int num3 = dp[index3] * 3;
            int num5 = dp[index5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) {
                index2++;
            }
            if (dp[i] == num3) {
                index3++;
            }
            if (dp[i] == num5) {
                index5++;
            }
        }
        return dp[n];
    }
}

