package month11.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/15 14:48
 */
public class demo3 {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = ratings[i] > ratings[i - 1] ? dp[i - 1] + 1 : 1;
        }
        for (int i = length - 2; i >= 0; i--) {
            dp[i] = ratings[i] > ratings[i + 1] ? Math.max(dp[i], dp[i + 1] + 1) : dp[i];
        }
        int res = 0;
        for (int i : dp) {
            res += i;
        }
        return res;
    }
}

