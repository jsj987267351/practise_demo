package Blue.month04.day01;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/1 13:37
 */
public class Blue14_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
//        false为白，ture为黑
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            for (int row = x1 - 1; row < x2; row++) {
                for (int col = y1 - 1; col < y2; col++) {
                    arr[row][col] = !arr[row][col];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j]) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}

