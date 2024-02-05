package Blue.month02.day04;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/4 16:57
 */
public class P8782_ {
    //    洛谷上题目A和B长度可能不一致，可能A的长度大于B，所以B不足的长度位置补0
    private static long[] A = new long[100010];
    private static long[] B = new long[100010];
    private static long[] T = new long[100010];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Alen = scanner.nextInt();
        for (int i = Alen - 1; i >= 0; i--) {
            A[i] = scanner.nextLong();
        }
        int Blen = scanner.nextInt();
        for (int i = Blen - 1; i >= 0; i--) {
            B[i] = scanner.nextLong();
        }
//        初始化为每一位可以达到的最小进制,也就是答案的差值最小,因为A>=B
        for (int i = 0; i < Math.max(Alen, Blen); i++) {
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

