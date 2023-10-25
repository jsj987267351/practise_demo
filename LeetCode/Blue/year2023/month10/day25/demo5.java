package year2023.month10.day25;


import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/25 17:18
 */
public class demo5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        LocalDate now = LocalDate.of(2000, 1, 1);
        LocalDate end = LocalDate.of(2020, 10, 2);
        int res = 0;
        int week = 6;
        while (now.isBefore(end)) {
            if (week % 7 == 1 || now.getDayOfMonth() == 1) {
                res += 2;
            } else {
                res += 1;
            }
            now = now.plusDays(1);
            week++;
        }
        System.out.println(res);
        scan.close();
    }

    public void temp() {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        LocalDate now = LocalDate.of(2000, 1, 1);
        LocalDate end = LocalDate.of(2020, 10, 2);
        int res = 0;
        while (now.isBefore(end)) {
            if (now.getDayOfWeek().getValue() == 1 || now.getDayOfMonth() == 1) {
                res += 2;
            } else {
                res += 1;
            }
            now = now.plusDays(1);
        }
        System.out.println(res);
        scan.close();
    }
}

