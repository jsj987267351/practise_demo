package year2023.month10.day24;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/24 16:40
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int[] dp = new int[10];
        for (int i = 0; i < 10; i++) {
            dp[i] = 2021;
        }
        int res = 1;
        boolean flag = true;
        while (true) {
            char[] chars = String.valueOf(res).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (dp[chars[i] - '0'] == 0) {
                    flag = false;
                    break;
                }
                dp[chars[i] - '0']--;
            }
            if (!flag) {
                break;
            }
            res++;
        }
        System.out.println(res - 1);
        scan.close();
    }
}

