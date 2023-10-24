package year2023.month10.day24;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/24 17:32
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int num = scan.nextInt();
        int[][] temp = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                temp[i][j] = scan.nextInt();
            }
        }
//        首先常规往下动态规划走
        for (int i = 1; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0) {
                    temp[i][j] += Math.max(temp[i - 1][j], temp[i - 1][j - 1]);
                } else {
                    temp[i][j] += temp[i - 1][j];
                }
            }
        }
//        因为向左步数与向右步数差不能超过1，所以最终一定是走到最后一行的中间，判断中间最大值即可
        if (num % 2 != 0) {
            System.out.println(temp[num - 1][num / 2]);
        } else {
            System.out.println(Math.max(temp[num - 1][num / 2], temp[num - 1][num / 2 - 1]));
        }
        scan.close();
    }
}

