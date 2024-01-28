package Blue.month01.day24;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/24 13:53
 */
public class P8601_ {
    private static int rowLength;
    private static int colLength;
    private static int sum = 0;
    private static int target = 0;
    private static int min;
    private static boolean[][] used;
    private static int[][] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rowLength = scanner.nextInt();
        colLength = scanner.nextInt();
        arr = new int[rowLength][colLength];
        used = new boolean[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                arr[i][j] = scanner.nextInt();
                sum += arr[i][j];
            }
        }
        if (sum % 2 != 0) {
            System.out.println(0);
            return;
        }
        min = rowLength * colLength;
        target = sum / 2;
        DFS(0, 0, 0, 0);
        if (min == rowLength * colLength) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
        scanner.close();
    }

    public static void DFS(int row, int col, int curSum, int Total) {
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || used[row][col] || curSum > target || Total > min) {
            return;
        }
        if (curSum == target) {
            min = Math.min(min, Total);
            return;
        }
        curSum += arr[row][col];
        used[row][col] = true;
        DFS(row, col - 1, curSum, Total + 1);
        DFS(row - 1, col, curSum, Total + 1);
        DFS(row, col + 1, curSum, Total + 1);
        DFS(row + 1, col, curSum, Total + 1);
        curSum -= arr[row][col];
        used[row][col] = false;
    }
}

