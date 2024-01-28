package Blue.month01.day21;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/21 17:00
 */
public class P9240 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int max = Integer.MAX_VALUE, min = 0;
        for (int i = 0; i < sum; i++) {
            int O = scanner.nextInt();
            int X = scanner.nextInt();
            int curMax = O / X;
            int curMin = O / (X +1) +1;
            min = Math.max(min, curMin);
            max = Math.min(max, curMax);
        }
        System.out.println(min + " " + max);
        scanner.close();
    }
}

