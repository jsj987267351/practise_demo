package Blue.month01.day31;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://www.lanqiao.cn/problems/3502/learning/?page=1&first_category_id=1&name=%E5%B9%B3%E6%96%B9%E5%B7%AE
 * @date 2024/1/31 18:24
 */
public class P9231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long L = scanner.nextLong();
        long R = scanner.nextLong();
//        利用公式计算(L,R)之间的奇数以及4的倍数的总数目，L与R单独计算两次
        long count = (R % 4 == 0 ? (R / 4 - 1) : R / 4) - (L % 4 == 0 ? (L / 4 + 1) : L / 4) + (R / 2 - (L % 2 == 1 ? (L / 2 + 1) : L / 2));
        if (check(L)) count++;
        if (check(R)) count++;
        System.out.println(count);
        scanner.close();
    }

    public static boolean check(long num) {
        if (num % 2L == 1L) return true;
        if (num % 4L == 0L) return true;
        return false;
    }
}

