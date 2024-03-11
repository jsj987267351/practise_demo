package Blue.month03.day11;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/11 13:39
 */
public class A4964 {
    private static int mod = 998244353;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowLength = scanner.nextInt();
        int colLength = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] arr = new int[rowLength][colLength];
//        表示每一行b个连续数字的最大值，因为一行一共有 colLength 个数字，每b个为一组，所以一共有 colLength - b + 1 组
        int[][] rowMax = new int[rowLength][colLength - b + 1];
        int[][] rowMin = new int[rowLength][colLength - b + 1];
        for (int row = 0; row < rowLength; row++) {
//            表示当前行第几组
            int index = 0;
            for (int col = 0; col < colLength; col++) {
//                存储元素
                arr[row][col] = scanner.nextInt();
//                每一组最少要到第b个才能开始找最大值和最小值
                if (col >= b - 1) {
                    int max = Integer.MIN_VALUE;
                    int min = Integer.MAX_VALUE;
                    for (int pre = col; pre >= col - b + 1; pre--) {
                        max = Math.max(max, arr[row][pre]);
                        min = Math.min(min, arr[row][pre]);
                    }
//                    记录当前行当前组的最大值和最小值
                    rowMax[row][index] = max;
                    rowMin[row][index] = min;
                    index++;
                }
            }
        }
//        开始统计结果
        int res = 0;
//        每次统计a行的最大值和最小值，所以统计到n-a就到底了，后面行数不足了
        for (int row = 0; row <= rowLength - a; row++) {
//            列数
            for (int col = 0; col < colLength - b + 1; col++) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
//            结尾行
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

