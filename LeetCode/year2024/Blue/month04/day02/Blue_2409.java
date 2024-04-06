package Blue.month04.day02;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/3 13:29
 */
public class Blue_2409 {
    public static void main(String[] args) {
        int arr[] = {99, 22, 51, 63, 72, 61, 20, 88, 40, 21, 63, 30, 11, 18, 99, 12, 93, 16, 7, 53, 64, 9, 28, 84, 34, 96, 52, 82, 51, 77};
        int res = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = i + 1; j < 30; j++) {
                if (arr[i] * arr[j] >= 2022) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}

