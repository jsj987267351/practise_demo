package Blue.month01.day28;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/28 15:21
 */
public class P9232 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] arr = line.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    res++;
                } else if (arr[i] == arr[j]) {
                    int left = i + 1, right = j - 1;
                    while (left < right) {
                        if (arr[left] > arr[right]) {
                            res++;
                            break;
                        } else if (arr[left] < arr[right]) {
                            break;
                        } else {
                            left++;
                            right--;
                        }
                    }
                }
            }
        }
        System.out.println(res);
        scanner.close();
    }
}

