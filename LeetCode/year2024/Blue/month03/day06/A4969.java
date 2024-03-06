package Blue.month03.day06;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/6 16:31
 */
public class A4969 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int[] arr = new int[26];
        for (int i = 0; i < string.length(); i++) {
            arr[string.charAt(i) - 'A']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max,arr[i]);
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == max){
                System.out.print((char) ('A' + i));
            }
        }
        scanner.close();
    }
}

