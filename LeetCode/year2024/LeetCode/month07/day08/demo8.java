package LeetCode.month07.day08;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/8 10:40
 */
public class demo8 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int mod = (int) (1e9 + 7);
        int maxRowLength = horizontalCuts[0], maxColLength = verticalCuts[0], hLength = horizontalCuts.length, vLength = verticalCuts.length;
        for (int i = 1; i < hLength; i++) {
            maxRowLength = Math.max(maxRowLength, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxRowLength = Math.max(maxRowLength, h - horizontalCuts[hLength - 1]);
        for (int i = 1; i < vLength; i++) {
            maxColLength = Math.max(maxColLength, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxColLength = Math.max(maxColLength, w - verticalCuts[vLength - 1]);
        long res = (long) maxRowLength * maxColLength;
        return (int) (res % mod);
    }
}

