package Blue.month03.day11;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/11 15:40
 */
public class A5396 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
//        false为白棋，true为黑棋
        boolean[][] arr = new boolean[len][len];
        int rowLength = scanner.nextInt();
        for (int i = 0; i < rowLength; i++) {
            int upRow = scanner.nextInt() - 1;
            int leftCol = scanner.nextInt() - 1;
            int bottomRow = scanner.nextInt() - 1;
            int rightCol = scanner.nextInt() - 1;
            for (int row = upRow; row <= bottomRow; row++) {
                for (int col = leftCol; col <= rightCol; col++) {
                    arr[row][col] = !arr[row][col];
                }
            }
        }
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if (arr[row][col]) {
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

