package Blue.month03.day07;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/7 13:30
 */
public class A4666 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long K = scanner.nextLong();
        long left = 0, right = Long.MAX_VALUE;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (help(mid) >= K) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (help(left) == K) {
            System.out.println(left);
        } else {
            System.out.println(-1);
        }
        scanner.close();
    }

    //    求末尾0数,末尾0只能由5*2得来，所以求有多少5即可，注意每次/5，是因为5的指数由多个5得来
    public static long help(long num) {
        long res = 0;
        while (num != 0) {
            res += num / 5;
            num /= 5;
        }
        return res;
    }
}

