package Blue.month03.day06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/6 16:05
 */
public class A4965 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        记录
        long[] A = new long[n];
        long[] B = new long[n];
        long[] C = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            C[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            long a = A[i];
            long b = B[i];
            long c = C[i];
//            数组数据更新为如果经历当天事件的话，当前国家与其他国家的差值为多少
            A[i] = a - b - c;
            B[i] = b - a - c;
            C[i] = c - a - b;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        long sumA = 0, sumB = 0, sumC = 0;
        int res = -1;
        for (int i = n - 1; i >= 0; i--) {
//        对数组进行排序,然后倒序遍历，每个数组存放的倒序就是对每个国家最有利的排放顺序,并且已经计算为了差值
//        只要有一个国家还满足条件，就说明当前该国家可以继续遍历下去
            sumA += A[i];
            sumB += B[i];
            sumC += C[i];
            if (sumA > 0 || sumB > 0 || sumC > 0) {
                res = n - i;
            }
        }
        System.out.println(res);
        scanner.close();
    }
}

