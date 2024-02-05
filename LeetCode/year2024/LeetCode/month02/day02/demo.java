package LeetCode.month02.day02;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/2 11:05
 */
public class demo {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
//        灵神
        int length = aliceValues.length;
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, (a, b) -> aliceValues[b] + bobValues[b] - aliceValues[a] - bobValues[a]);
//        A为aliceValues所拿总和，B为bobValues所拿总和
        int A = 0, B = 0;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                A += aliceValues[arr[i]];
            } else {
                B += bobValues[arr[i]];
            }
        }
        if (A > B){
            return 1;
        }else if (A < B){
            return -1;
        }
        return 0;
    }
}

