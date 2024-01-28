package Blue.month01.day22;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/22 14:12
 */
public class P9237__ {
    private static int n;
    private static int m;
    private static int[][] res;
    private static int[][] cur;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
//        上下左右各添一行0，方便判断边界
        res = new int[n + 2][m + 2];
        cur = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            String line = scanner.nextLine();
            for (int j = 1; j <= line.length(); j++) {
                if (line.charAt(j - 1) != '_') {
                    cur[i][j] = line.charAt(j - 1) - '0';
                } else {
                    cur[i][j] = -1;
                }
            }
        }
        DFS(1, 1);
        scanner.close();
    }

    public static void DFS(int row, int col) {

    }

    //  求出九个方向总和
    public static int getSum(int row, int col) {
        int count = 0;
        if (res[row - 1][col - 1] == 1) count++;
        if (res[row - 1][col] == 1) count++;
        if (res[row - 1][col + 1] == 1) count++;
        if (res[row][col - 1] == 1) count++;
        if (res[row][col] == 1) count++;
        if (res[row][col + 1] == 1) count++;
        if (res[row + 1][col - 1] == 1) count++;
        if (res[row + 1][col] == 1) count++;
        if (res[row + 1][col + 1] == 1) count++;
        return count;
    }

    //    判断当前格子是否符合条件
    public static boolean check(int row, int col) {
        if (cur[row][col] == -1) return true;
        return cur[row][col] == getSum(row, col);
    }
}

