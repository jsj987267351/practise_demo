package Blue.month02.day05;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/5 14:33
 */
public class P8780 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long n = scanner.nextLong();
        scanner.close();
//        每周会做几道题目
        long weekNum = a * 5 + b * 2;
//        需要用几周
        long week = n / weekNum;
//        做了几周后剩余的题目
        long last = n - week * weekNum;
        long res = week * 7;
        for (int i = 0; i < 5; i++) {
            if (last <= 0) break;
            res++;
            last -= a;
        }
        for (int i = 0; i < 2; i++) {
            if (last <= 0) break;
            res++;
            last -= b;
        }
        System.out.println(res);
    }
}

