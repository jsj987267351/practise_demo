package LeetCode.month06.shenXinFu;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 19:44
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int k = 0; k < n; k++) {
            String pre = scanner.next();
            String aft = scanner.next();
            char[] charPre = pre.toCharArray();
            char[] charAft = aft.toCharArray();
            int len1 = charPre.length;
            int len2 = charAft.length;
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int i = 0; i <= len1; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= len2; i++) {
                dp[0][i] = i;
            }
            for (int preIndex = 1; preIndex <= len1; preIndex++) {
                for (int aftIndex = 1; aftIndex <= len2; aftIndex++) {
                    if (charPre[preIndex - 1] == charAft[aftIndex - 1]) {
                        dp[preIndex][aftIndex] = dp[preIndex - 1][aftIndex - 1];
                    } else {
                        dp[preIndex][aftIndex] = 1 + Math.min(Math.min(dp[preIndex - 1][aftIndex], dp[preIndex][aftIndex - 1]), dp[preIndex - 1][aftIndex - 1]);
                    }
                }
            }
            System.out.println(dp[len1][len2]);
        }
        scanner.close();
    }
}

