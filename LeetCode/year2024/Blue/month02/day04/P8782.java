package Blue.month02.day04;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/4 16:57
 */
public class P8782 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Alen = scanner.nextInt();
        int[] A = new int[Alen];
        for (int i = Alen - 1; i >= 0; i--) {
            A[i] = scanner.nextInt();
        }
        int Blen = scanner.nextInt();
        int[] B = new int[Blen];
        for (int i = Blen - 1; i >= 0; i--) {
            B[i] = scanner.nextInt();
        }
//        A和B用的是同一进制，定义数组表示每一位的进制
        int[] T = new int[Alen];
//        初始化为每一位可以达到的最大进制,也就是答案的差值最小,因为A>=B
        for (int i = 0; i < Alen; i++) {
            T[i] = Math.max(Math.max(A[i], B[i]) + 1, 2);
        }
        int mod = 1000000007;
//        开始计算，对于i位上的数字num[i]，转换为十进制就是num[i]*低于i位所有位的进制
        long resA = 0, resB = 0;
        for (int i = Alen - 1; i >= 0; i--) {
            resA = (resA * T[i] + A[i]) % mod;
        }
        for (int i = Blen - 1; i >= 0; i--) {
            resB = (resB * T[i] + B[i]) % mod;
        }
        System.out.println((resA - resB + mod) % mod);
        scanner.close();
    }
}

