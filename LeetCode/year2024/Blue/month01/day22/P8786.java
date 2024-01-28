package Blue.month01.day22;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/22 15:37
 */
public class P8786 {
    private static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
//        dp[i][j][k]遇到i家店和j家花剩余k斗酒的可能总数
        int[][][] dp = new int[N + 1][M + 1][M + 5];
        dp[0][0][2] = 1;//初始2斗酒
//        遇到店的数量
        for (int i = 0; i <= N; i++) {
//            遇到花的数量
            for (int j = 0; j <= M; j++) {
//            当前酒壶有多少斗酒,最多只能有M斗，多了喝不完
                for (int k = 0; k <= M; k++) {
//                    只有遇到过店，并且当前酒壶里的酒为偶数时，前一家店才可能为店
                    if (i > 0 && k % 2 == 0) {
                        dp[i][j][k] += dp[i - 1][j][k / 2] % mod;
                    }
//                    只要遇到过花，那么不管当前酒壶里的酒为单数还是双数，前一家店都可能为花店
                    if (j > 0) {
                        dp[i][j][k] += dp[i][j - 1][k + 1] % mod;
                    }
                }
            }
        }
//        因为最后一家一定要是花店，所以输出遇到N家店和M-1家花后酒壶剩余1斗的情况
        System.out.println(dp[N][M - 1][1] % mod);
        scanner.close();
    }
}

