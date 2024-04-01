package Blue.month04.day01;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/1 13:31
 */
public class Blue14_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long res = 0;
        LocalDate cur = LocalDate.of(1900, 1, 1);
        LocalDate end = LocalDate.of(9999, 12, 31);
        while (cur.isBefore(end)) {
            int year = cur.getYear();
            int month = cur.getMonthValue();
            int day = cur.getDayOfMonth();
            int pre = 0, lat = 0;
            while (year > 0) {
                pre += year % 10;
                year /= 10;
            }
            while (month > 0) {
                lat += month % 10;
                month /= 10;
            }
            while (day > 0) {
                lat += day % 10;
                day /= 10;
            }
            if (pre == lat) res++;
            cur = cur.plusDays(1);
        }
        System.out.println(res);
        scanner.close();
    }
}

