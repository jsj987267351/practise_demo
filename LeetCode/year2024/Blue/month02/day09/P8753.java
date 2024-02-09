package Blue.month02.day09;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/9 15:21
 */
public class P8753 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (((i * i) % n) * 2 < n) res++;
        }
        System.out.println(res);
        scanner.close();
    }
}

