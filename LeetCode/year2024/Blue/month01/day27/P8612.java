package Blue.month01.day27;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/27 16:07
 */
public class P8612 {
    private static int n;
    private static int m;
    private static int k;
    private static int arr[][];
    private static int mod = 1000000007;
//    dp[i][j][k][l]含义：到达下标i,j时，拿走l个宝贝，并且这些宝贝中最大价值为k的方案数
    private static long dp[][][][] = new long[50][50][14][13];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                for (int l = 0; l < 14; l++) {
                    for (int o = 0; o < 13; o++) {
                        dp[i][j][l][o] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
//        curMax设置为0是因为宝贝的价格可能也为0
        long res = DFS(0, 0, -1, 0);
        System.out.println(res);
        scanner.close();
    }

    //    函数意义，从row，col出发一共有多少种方案，curMax为当前身上宝贝中最贵的价格，count为已经拿的宝贝数量
    public static long DFS(int row, int col, int curMax, int count) {
        if (dp[row][col][curMax + 1][count] != -1) {
            return dp[row][col][curMax + 1][count];
        }
        if (row >= n || col >= m || count > k) return 0;
//        当前宝贝的价值
        int cur = arr[row][col];
//        以当前下标出发到达出口的方案数目
        long res = 0;
        if (row == n - 1 && col == m - 1) {
//            到达最后一个出口点,当前格子宝贝不拿并且数量已经够或者还差一个并且当前宝贝满足拿的条件，都+1，代表多一种方案
            if (count == k || cur > curMax && count == k - 1) {
                return 1;
            }
        }
//        拿与不拿的情况，拿的情况只有当前宝贝比所带宝贝都贵才可以
        if (cur > curMax) {
//            拿的情况
            res += DFS(row, col + 1, cur, count + 1);
            res += DFS(row + 1, col, cur, count + 1);
        }
//        不拿的情况
        res += DFS(row, col + 1, curMax, count);
        res += DFS(row + 1, col, curMax, count);
        res %= mod;
        dp[row][col][curMax + 1][count] = res;
        return res;
    }
}

