package Blue.month04.day01;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/1 13:47
 */
public class Blue14_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mod = 998244353;
        int rowLength = scanner.nextInt();
        int colLength = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] arr = new int[rowLength][colLength];
        int[][] rowMax = new int[rowLength][colLength - b + 1];
        int[][] rowMin = new int[rowLength][colLength - b + 1];
        for (int row = 0; row < rowLength; row++) {
            int index = 0;
            for (int col = 0; col < colLength; col++) {
                arr[row][col] = scanner.nextInt();
                if (col >= b - 1) {
                    int max = Integer.MIN_VALUE;
                    int min = Integer.MAX_VALUE;
                    for (int curCol = col, sum = b; sum > 0; sum--, curCol--) {
                        max = Math.max(max, arr[row][curCol]);
                        min = Math.min(min, arr[row][curCol]);
                    }
                    rowMax[row][index] = max;
                    rowMin[row][index] = min;
                    index++;
                }
            }
        }
        int res = 0;
        for (int row = 0; row <= rowLength - a; row++) {
            for (int col = 0; col <= colLength - b; col++) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int endRow = row; endRow < row + a; endRow++) {
                    max = Math.max(max, rowMax[endRow][col]);
                    min = Math.min(min, rowMin[endRow][col]);
                }
                res = (res + (max * min) % mod) % mod;
            }
        }
        System.out.println(res);
        scanner.close();
    }
}

