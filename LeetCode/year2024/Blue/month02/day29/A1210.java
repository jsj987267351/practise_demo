package Blue.month02.day29;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/29 14:14
 */
public class A1210 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = len;
        for (int i = 0; i < len; i++) {
            int max = arr[i];
            int min = arr[i];
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == j - i) res++;
            }
        }
        System.out.println(res);
        scanner.close();
    }
}

