package Blue.month02.day09;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/9 15:27
 */
public class P8754 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long res = 0;
        for (long i = 1; i <= n; i++) {
            if (help(n * i)) {
                res = i;
                break;
            }
        }
        System.out.println(res);
        scanner.close();
    }

    public static boolean help(long num) {
        long left = 1, right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

