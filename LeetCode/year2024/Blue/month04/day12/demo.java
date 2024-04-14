package Blue.month04.day12;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/12 15:48
 */
public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        String S = scanner.next();
        char[] chars = S.toCharArray();
        for (int i = 0; i < Q; i++) {
            int left = scanner.nextInt() - 1;
            int right = scanner.nextInt() - 1;
            int count = scanner.nextInt() % 26;
            for (; left <= right; left++) {
                int index = chars[left] - 'a';
                index = (index + count) % 26;
                chars[left] = c[index];
            }
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        scanner.close();
    }
}

