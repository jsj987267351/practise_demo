package Blue.month02.day29;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/29 12:57
 */
public class A1205 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = m * n; i > 0; i--) {
            int temp = i;
            while (temp % n != 0 && temp > m) temp -= m;
            if (temp % n != 0 && i % n != 0 && i % m != 0) {
                System.out.println(i);
                break;
            }
        }
        scanner.close();
    }
}

