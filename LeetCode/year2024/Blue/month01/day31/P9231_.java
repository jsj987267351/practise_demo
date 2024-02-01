package Blue.month01.day31;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/31 18:44
 */
public class P9231_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        System.out.println(four(R) - four(L - 1) + Ji(R) - Ji(L - 1));
        scanner.close();
    }

    //    计算[0，num]之间有多少4的倍数
    public static int four(int num) {
        return num / 4;
    }

    //    计算[0，num]之间有多少奇数
    public static int Ji(int num) {
        return num % 2 == 0 ? num / 2 : num / 2 + 1;
    }
}

