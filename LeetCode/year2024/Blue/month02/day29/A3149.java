package Blue.month02.day29;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/29 14:55
 */
public class A3149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rowLength = 5 + n * 4;
        char[][] res = new char[rowLength][rowLength];
//        初始化
        for (char[] re : res) {
            Arrays.fill(re, '0');
        }
//        初始化中间的十字架
        for (int centerRow = rowLength / 2 - 2; centerRow <= rowLength / 2 + 2; centerRow++) {
            res[centerRow][rowLength / 2] = '$';
        }
        for (int centerCol = rowLength / 2 - 2; centerCol <= rowLength / 2 + 2; centerCol++) {
            res[rowLength / 2][centerCol] = '$';
        }
//        开始扩散绣花，总共绣n个，每次遍历会从里开始绣花
        int cur = 0;
        while (cur < n) {
//            绣白
            for (int row = 0; row < rowLength; row++) {
                for (int col = 0; col < rowLength; col++) {
//                   判断8个方向
                    if (res[row][col] == '0' && ((col > 0 && res[row][col - 1] == '$') || (row > 0 && col > 0 && res[row - 1][col - 1] == '$') || (row > 0 && res[row - 1][col] == '$') ||
                            (row > 0 && col < rowLength - 1 && res[row - 1][col + 1] == '$') || (col < rowLength - 1 && res[row][col + 1] == '$') ||
                            (row < rowLength - 1 && col < rowLength - 1 && res[row + 1][col + 1] == '$') || (row < rowLength - 1 && res[row + 1][col] == '$') || (row < rowLength - 1 && col > 0 && res[row + 1][col - 1] == '$'))) {
                        res[row][col] = '.';
                    }
                }
            }
//            绣花
            for (int row = 0; row < rowLength; row++) {
                for (int col = 0; col < rowLength; col++) {
//                   判断8个方向
                    if (res[row][col] == '0' && ((col > 0 && res[row][col - 1] == '.') || (row > 0 && col > 0 && res[row - 1][col - 1] == '.') || (row > 0 && res[row - 1][col] == '.') ||
                            (row > 0 && col < rowLength - 1 && res[row - 1][col + 1] == '.') || (col < rowLength - 1 && res[row][col + 1] == '.') ||
                            (row < rowLength - 1 && col < rowLength - 1 && res[row + 1][col + 1] == '.') || (row < rowLength - 1 && res[row + 1][col] == '.') || (row < rowLength - 1 && col > 0 && res[row + 1][col - 1] == '.'))) {
                        res[row][col] = '$';
                    }
                }
            }
//            绣花完成
            cur++;
        }
//        把四个角上符号变为点
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                res[row][col] = '.';
                res[row][rowLength - col - 1] = '.';
                res[rowLength - row - 1][col] = '.';
                res[rowLength - row - 1][rowLength - col - 1] = '.';
            }
        }
//        输出
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
        scanner.close();
    }
}

