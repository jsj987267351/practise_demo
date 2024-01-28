package Blue.month01.day23;


import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/23 14:31
 */
public class P8600 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = length;
        for (int i = 0; i < length; i++) {
            int max = arr[i];
            int min = arr[i];
            for (int j = i + 1; j < length; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == j - i) res++;
            }
        }
        System.out.println(res);
        scanner.close();
    }
}

