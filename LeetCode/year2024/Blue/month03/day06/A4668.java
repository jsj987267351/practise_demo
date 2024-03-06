package Blue.month03.day06;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/6 17:26
 */
public class A4668 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mod = 1000000007;
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
//        dp[i]表示长度为i时的分割数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int max = arr[i];
            int min = arr[i];
//            首先单挂先算上
            dp[i] = dp[i - 1];
            for (int j = i - 1; j > 0; j--) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == i - j) {
                    dp[i] = (dp[i] + dp[j - 1]) % mod;
                }
            }
        }
        System.out.println(dp[n]);
    }
}

