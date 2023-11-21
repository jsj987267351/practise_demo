package month11.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/21 15:08
 */
public class demo2 {
    public int findMaxForm(String[] strs, int m, int n) {
//        m:0 n:1
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int numZero = 0, numOne = 0;
            for (char c : str.toCharArray()) {
                if (c - '0' == 0) {
                    numZero++;
                } else {
                    numOne++;
                }
            }
            for (int zero = m; zero >= numZero; zero--) {
                for (int one = n; one >= numOne; one--) {
                    dp[zero][one] = Math.max(dp[zero][one], dp[zero - numZero][one - numOne] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

