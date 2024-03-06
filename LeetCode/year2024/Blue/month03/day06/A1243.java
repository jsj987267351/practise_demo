package Blue.month03.day06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/6 17:23
 */
public class A1243 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
//        dp[i]表示满足i种状态下需要最少购买的总数，这里状态指的是二进制，比如M为2的话，那么状态只有00，01，10，11四种，也就是2的2次方，即1<<2
//        初始值设置为max/2，因为后续会添加糖果也就是+1，否则会溢出，dp[0]表示状态00的最少购买总数，也就是都不买即可，即为0
        int[] dp = new int[1 << M];
        Arrays.fill(dp, Integer.MAX_VALUE >> 1);
        dp[0] = 0;
//        arr[i]表示第i包糖的状态,例如第一包糖为112，总糖数目为5的话，状态即为00011
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
//            统计当袋糖果的状态
            int temp = 0;
            for (int j = 0; j < K; j++) {
                temp |= 1 << (scanner.nextInt() - 1);
            }
            arr[i] = temp;
        }
//        01背包问题
//        先遍历物品
        for (int i = 0; i < N; i++) {
//            后遍历背包，倒序遍历
            for (int j = (1 << M) - 1; j >= 0; j--) {
//             当前背包物品加上当前物品表示为  j | arr[i]
                dp[j | arr[i]] = Math.min(dp[j | arr[i]], dp[j] + 1);
            }
        }
        System.out.println(dp[(1 << M) - 1] == Integer.MAX_VALUE >> 1 ? -1 : dp[(1 << M) - 1]);
        scanner.close();
    }
}

