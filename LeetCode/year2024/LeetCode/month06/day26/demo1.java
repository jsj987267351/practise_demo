package LeetCode.month06.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/26 9:26
 */
public class demo1 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = ratings[i] > ratings[i - 1] ? dp[i - 1] + 1 : 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            dp[i] = ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1] ? dp[i + 1] + 1 : dp[i];
        }
        int res = 0;
        for (int num : dp) {
            res += num;
        }
        return res;
    }
}

