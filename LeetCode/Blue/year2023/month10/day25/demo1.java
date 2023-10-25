package year2023.month10.day25;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/25 16:50
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int num = scan.nextInt();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double sum = 0;
        for (int i = 0; i < num; i++) {
            int curNum = scan.nextInt();
            sum += curNum;
            max = Math.max(max, curNum);
            min = Math.min(min, curNum);
        }
        double average = sum / num;
        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f", average);
        scan.close();
    }
}

