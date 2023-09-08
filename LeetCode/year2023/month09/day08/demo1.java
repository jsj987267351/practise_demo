package month09.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/8 14:22
 */
public class demo1 {
    public int waysToStep(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < n + 1; i++) {
//            因为数组往后越来越大，所以每次先将两个小的相加取模，防止越界。如果将两个大的相加在取模有可能越界
            dp[i] = (dp[i - 1] + (dp[i - 2] + dp[i - 3]) % 1000000007) % 1000000007;
        }
        return dp[n];
    }
}

