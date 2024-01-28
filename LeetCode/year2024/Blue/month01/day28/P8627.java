package Blue.month01.day28;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/28 15:15
 */
public class P8627 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Total = scanner.nextInt();
        int res = Total;
        while (Total > 2) {
            int cur = Total / 3;
            res += cur;
            Total -= cur * 3;
            Total += cur;
        }
        System.out.println(res);
        scanner.close();
    }
}

