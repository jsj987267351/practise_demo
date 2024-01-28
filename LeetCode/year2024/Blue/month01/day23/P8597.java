package Blue.month01.day23;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/23 13:10
 */
public class P8597 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String curString = scanner.nextLine();
        String targetString = scanner.nextLine();
        int length = curString.length();
        boolean[] cur = new boolean[length];
        boolean[] target = new boolean[length];
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (curString.charAt(i) == '*') {
                cur[i] = true;
            }
            if (targetString.charAt(i) == '*') {
                target[i] = true;
            }
        }
        for (int i = 0; i < length; i++) {
            if (cur[i] != target[i]) {
                cur[i] = !cur[i];
                cur[i + 1] = !cur[i + 1];
                res++;
            }
        }
        System.out.println(res);
        scanner.close();
    }
}

