package Blue.month03.day11;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/11 14:29
 */
public class A4658 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int res = 0;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                res++;
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        if (n > 1) res++;
        System.out.println(res);
        scanner.close();
    }
}

