package LeetCode.month06.shenXinFu;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 20:01
 */
public class demo3 {
    private static int rowLength;
    private static int colLength;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rowLength = scanner.nextInt();
        colLength = scanner.nextInt();
        int sum = scanner.nextInt();
        int[][] matrix = new int[rowLength][colLength];
        int[][] count = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            String next = scanner.next();
            for (int j = 0; j < colLength; j++) {
                matrix[i][j] = next.charAt(j) - '0';
            }
        }
        for (int i = 0; i < sum; i++) {
            count = new int[rowLength][colLength];
            for (int row = 0; row < rowLength; row++) {
                for (int col = 0; col < colLength; col++) {
                    count[row][col] = Count(matrix, row, col);
                }
            }
            for (int row = 0; row < rowLength; row++) {
                for (int col = 0; col < colLength; col++) {
                    int num = count[row][col];
                    if (matrix[row][col] == 1 && (num < 2 || num > 3)) {
                        matrix[row][col] = 0;
                    } else if (matrix[row][col] == 0 && num == 3) {
                        matrix[row][col] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        scanner.close();
    }

    public static int Count(int[][] matrix, int row, int col) {
        int res = 0;
//        左上
        if (row == 0) {
            if (col == 0) {
                res += matrix[rowLength - 1][colLength - 1];
            } else {
                res += matrix[rowLength - 1][col - 1];
            }
//            上
            res += matrix[rowLength - 1][col];
//            右上
            if (col == colLength - 1) {
                res += matrix[rowLength - 1][0];
            } else {
                res += matrix[rowLength - 1][col + 1];
            }
        } else {
            if (col == 0) {
                res += matrix[row - 1][colLength - 1];
            } else {
                res += matrix[row - 1][col - 1];
            }
            res += matrix[row - 1][col];
            if (col == colLength - 1) {
                res += matrix[row - 1][0];
            } else {
                res += matrix[row - 1][col + 1];
            }
        }
//        左下、下、右下
        if (row == rowLength - 1) {
            if (col == 0) {
                res += matrix[0][rowLength - 1];
            } else {
                res += matrix[0][col - 1];
            }
//            下
            res += matrix[0][col];
//            右下
            if (col == colLength - 1) {
                res += matrix[0][0];
            } else {
                res += matrix[0][col + 1];
            }
        } else {
            if (col == 0) {
                res += matrix[row + 1][rowLength - 1];
            } else {
                res += matrix[row + 1][col - 1];
            }
            res += matrix[row + 1][col];
            if (col == colLength - 1) {
                res += matrix[row + 1][0];
            } else {
                res += matrix[row + 1][col + 1];
            }
        }
//        左、右
        if (col == 0) {
            res += matrix[row][colLength - 1];
        } else {
            res += matrix[row][col - 1];
        }

        if (col == colLength - 1) {
            res += matrix[row][0];
        } else {
            res += matrix[row][col + 1];
        }
        return res;
    }
}

