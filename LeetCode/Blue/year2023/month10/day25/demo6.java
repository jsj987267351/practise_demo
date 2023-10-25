package year2023.month10.day25;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/25 17:38
 */
public class demo6 {
    public static void main(String[] args) {
//        把矩阵顺时针旋转90，看作宝塔，第n行有n个数字，要求求中间数字，奇数行才有中间数字，所以每两行有一个中间数字，所以第20个中间数字出现在 2*20 -1 = 39 行
//        所以首先利用等差述律计算前38行一共出现了多少数字，然后加上20即可得到中间数字
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int sum = 38 * 39 / 2;
        System.out.println(sum + 20);
        scan.close();
    }
}

