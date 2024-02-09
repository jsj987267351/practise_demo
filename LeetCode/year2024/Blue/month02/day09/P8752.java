package Blue.month02.day09;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/9 15:23
 */
public class P8752 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        for (int i = 0; i < 5; i++) {
            int cur = scanner.nextInt();
            if (check(cur)) res++;
        }
        System.out.println(res);
        scanner.close();
    }

    public static boolean check(int year) {
        int ge = year % 10;
        year /= 10;
        int shi = year % 10;
        year /= 10;
        int bai = year % 10;
        year /= 10;
        if (year == shi && ge == bai + 1) return true;
        return false;
    }
}

