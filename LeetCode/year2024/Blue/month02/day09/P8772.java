package Blue.month02.day09;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/9 15:10
 */
public class P8772 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
            res += arr[i] * sum;
        }
        System.out.println(res);
        scanner.close();
    }
}

