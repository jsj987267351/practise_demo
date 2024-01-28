package Blue.month01.day24;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/24 12:54
 */
public class P8601 {
    private static int rowLength;
    private static int colLength;
    private static int sum = 0;
    private static int target = 0;
    private static int min;
    private static boolean[][] used;
    private static int[][] arr;
    private static int[][] direction = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

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
        DFS(0, 0, arr[0][0], 1);
        used[0][0] = true;
        if (min == rowLength * colLength) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
        scanner.close();
    }

    public static void DFS(int row, int col, int curSum, int Total) {
        if (curSum == target) {
            min = Math.min(min, Total);
            return;
        }
        if (curSum > target) return;
        for (int i = 0, xx, yy; i < 4; i++) {
            xx =  row + direction[0][i];
            yy =  col + direction[1][i];
            if (xx >= 0 && xx < rowLength && yy >= 0 && yy < colLength && !used[xx][yy]) {
                used[xx][yy] = true;
                DFS(xx, yy, curSum + arr[xx][yy], Total + 1);
                used[xx][yy] = false;
            }
        }
    }
}

