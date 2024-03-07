package Blue.month03.day07;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/7 13:02
 */
public class A3174 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowLength = scanner.nextInt();
        int colLength = scanner.nextInt();
        int[][] arr = new int[rowLength][colLength];
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                arr[row][col] = scanner.nextInt();
            }
        }
        for (int col = 0; col < colLength; col++) {
            for (int row = rowLength - 1; row >= 0; row--) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

