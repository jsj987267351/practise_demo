package month10.day24;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/24 16:35
 */
public class demo5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int res = 0;
        for (int i = 1; i <= 2020; i++) {
            char[] s = String.valueOf(i).toCharArray();
            for (int j = 0; j < s.length; j++) {
                if (s[j] == '2') {
                    res++;
                }
            }
        }
        System.out.println(res);
        scan.close();
    }
}

