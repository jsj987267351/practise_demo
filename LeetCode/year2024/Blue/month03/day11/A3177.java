package Blue.month03.day11;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/11 15:54
 */
public class A3177 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if (N > 20) {
            System.out.println(0.61803399);
        } else {
            long a = 1, b = 1;
            for (int i = 3; i <= N + 1; i++) {
                long sum = a + b;
                a = b;
                b = sum;
            }
            System.out.println(String.format("%.8f", 1.0 * a / b));
        }
        scanner.close();
    }
}

