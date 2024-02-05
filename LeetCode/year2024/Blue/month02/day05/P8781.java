package Blue.month02.day05;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/5 14:23
 */
public class P8781 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] dp = new int[N];
//        模拟一下即可，注意，每次修建都是置0
        for (int i = 0; i < N; i++) {
            System.out.println(Math.max(i, N - i - 1) * 2);
        }
        scanner.close();
    }
}

