package LeetCode.month07.day25;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/25 9:46
 */
public class demo3 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int len = aliceValues.length;
        Integer[] index = new Integer[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> aliceValues[b] + bobValues[b] - aliceValues[a] - bobValues[a]);
        int A = 0, B = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                A += aliceValues[index[i]];
            } else {
                B += bobValues[index[i]];
            }
        }
        if (A > B) {
            return 1;
        } else if (A < B) {
            return -1;
        } else {
            return 0;
        }
    }
}

