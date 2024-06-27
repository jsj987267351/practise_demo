package LeetCode.month06.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/27 9:39
 */
public class demo2 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int[] count = countZeroAndOnes(strs[i]);
            int zeroCount = count[0];
            int oneCount = count[1];
            for (int j = m; j >= zeroCount; j--) {
                for (int k = n; k >= oneCount; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroCount][k - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] countZeroAndOnes(String s) {
        int countZero = 0, countOnes = 0;
        for (char c : s.toCharArray()) {
            if (c - '0' == 0) {
                countZero++;
            } else {
                countOnes++;
            }
        }
        return new int[]{countZero, countOnes};
    }
}

