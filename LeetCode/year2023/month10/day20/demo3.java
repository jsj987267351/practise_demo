package month10.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/unique-paths/?envType=list&envId=hliQiQFH
 * @date 2023/10/20 15:45
 */
public class demo3 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

