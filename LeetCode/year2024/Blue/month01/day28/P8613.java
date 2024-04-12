package Blue.month01.day28;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/28 13:27
 */
public class P8613 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
//        每个数字前面比他大和后面比他小的数字数量和，也即逆序对数量，交换数量
        int[] help = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
//            前
            for (int j = 0; j < i; j++) {
                if (arr[j] > cur) help[i]++;
            }
//            后
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < cur) help[i]++;
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += ((long) help[i] * (help[i] + 1) / 2);
        }
        System.out.println(res);
        scanner.close();
    }
}

