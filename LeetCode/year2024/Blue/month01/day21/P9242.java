package Blue.month01.day21;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/21 16:10
 */
public class P9242 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = scanner.nextInt();
        }
//        dp[i]表示以i结尾最长接龙
        int[] dp = new int[10];
        int res = 0;
        for (int i = 0; i < length; i++) {
//            头和尾
            int PreNum = temp[i];
            int afterNum = PreNum % 10;
            while (PreNum >= 10) {
                PreNum /= 10;
            }
//            连接在头上
            dp[afterNum] = Math.max(dp[afterNum], dp[PreNum] + 1);
            res = Math.max(res, dp[afterNum]);
        }
        System.out.println(length - res);
        scanner.close();
    }
}
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int length = scanner.nextInt();
//        int[] temp = new int[length];
//        int res = 1;
//        int[] dp = new int[length];
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < length; i++) {
//            temp[i] = scanner.nextInt();
//            int after = temp[i];
//            while (after >= 10) {
//                after /= 10;
//            }
//            for (int j = 0; j < i; j++) {
//                int pre = temp[j];
//                if (pre > 10) {
//                    pre = pre % 10;
//                }
//                if (after == pre) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//        System.out.println(length - res);
//        scanner.close();
//    }


