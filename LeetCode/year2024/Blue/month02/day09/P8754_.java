package Blue.month02.day09;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/9 15:27
 */
public class P8754_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long res = 1;
        for (long i = 2; i * i < n; i++) {
            int count = 0;
            while (n % i == 0) {
                n /= i;
                count++;
            }
            if (count % 2 == 1) res *= i;
        }
        System.out.println(res * n);
        scanner.close();
    }
}

