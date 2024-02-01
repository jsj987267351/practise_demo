package Blue.month02.day01;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/1 20:03
 */
public class P8783 {
    private static int rowLength;
    private static int colLength;
    private static long max;
    private static long arr[][];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rowLength = scanner.nextInt();
        colLength = scanner.nextInt();
        max = scanner.nextLong();
        arr = new long[rowLength + 1][colLength + 1];
        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                arr[i][j] = scanner.nextLong();
            }
        }
//        leetcode 最大子矩阵
        long[][] preSum = new long[rowLength + 1][colLength + 1];
        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                preSum[i][j] = arr[i][j] +  preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }
        int res = 0;
        for (int top = 1; top <= rowLength; top++) {
            for (int bottom = top; bottom <= rowLength; bottom++) {
                for (int left = 1; left <= colLength; left++) {
                    for (int right = left; right <= colLength; right++) {
                        long curNum = preSum[bottom][right] + preSum[top - 1][left - 1] - preSum[top - 1][right] - preSum[bottom][left - 1];
                        if (curNum <= max) {
                            res++;
                        }
                    }
                }
            }
        }
        System.out.println(res);
        scanner.close();
    }
}

