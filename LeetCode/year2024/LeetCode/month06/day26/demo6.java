package LeetCode.month06.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/26 10:17
 */
public class demo6 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int indexTwo = 1, indexThree = 1, indexFive = 1;
        for (int i = 2; i <= n; i++) {
            int numTwo = dp[indexTwo] * 2;
            int numThree = dp[indexThree] * 3;
            int numFive = dp[indexFive] * 5;
            int num = Math.min(numTwo, Math.min(numThree, numFive));
            dp[i] = num;
            if (num == numTwo) {
                indexTwo++;
            }
            if (num == numThree) {
                indexThree++;
            }
            if (num == numFive) {
                indexFive++;
            }
        }
        return dp[n];
    }
}

