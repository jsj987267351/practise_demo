package LeetCode.month01.day02;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/2 12:51
 */
public class demo3 {
    int mod = (int) (1e9 + 7);

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hLength = horizontalCuts.length;
        int wLength = verticalCuts.length;
        int maxH = horizontalCuts[0], maxW = verticalCuts[0];
        for (int i = 1; i < hLength; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < wLength; i++) {
            maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxH = Math.max(maxH, h - horizontalCuts[hLength - 1]);
        maxW = Math.max(maxW, w - verticalCuts[wLength - 1]);
        long res = (long)maxH * maxW;
        return (int) (res%mod);
    }
}

