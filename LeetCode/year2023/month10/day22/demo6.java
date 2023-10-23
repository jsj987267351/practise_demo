package month10.day22;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/22 20:54
 */
public class demo6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int num = scan.nextInt();
        double x = 0, y = 0;
        for (int i = 0; i < num; i++) {
            int temp = scan.nextInt();
            if (temp >= 60) {
                if (temp >= 85) {
                    y++;
                }
                x++;
            }
        }
        System.out.println(Math.round(x * 100 / num) + "%");
        System.out.println(Math.round(y * 100 / num) + "%");
        scan.close();
    }
}

