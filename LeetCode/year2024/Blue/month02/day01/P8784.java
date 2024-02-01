package Blue.month02.day01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/1 19:35
 */
public class P8784 {
    private static int mod = 1000000007;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
//        dp[0][i]表示前面一列有i个积木的方式总数，dp[1][i]表示当前列列有i个积木的方式总数
        long[][] dp = new long[2][3];
//        首先给第一列赋初值
//        第一列可以没有积木，不放即可，也可以有两个积木，放一个I型即可
        dp[0][0] = 1;
        dp[0][2] = 1;
        for (int i = 1; i < n; i++) {
//            当前列没有积木方式与前一列有两个积木一致
            dp[1][0] = dp[0][2] % mod;
//            当前列有一个积木方式，可以分为前一列有一个积木，可以横着放一个I型积木，前一列没有积木的话，可以正反放L型积木所以*2
            dp[1][1] = (dp[0][1] + dp[0][0] * 2) % mod;
//            当前列有两个积木方式，前一列没有积木可以横着放两个I，前一列有一个积木可以放一个L，前一列有两个积木可以竖着放一个I
            dp[1][2] = (dp[0][0] + dp[0][1] + dp[0][2]) % mod;
//           下次遍历时，当前列变为前一列，更新
            dp[0] = Arrays.copyOf(dp[1], 3);
        }
//        输出最后一列铺满的方式总数
        System.out.println(dp[1][2]);
        scanner.close();
    }
}

