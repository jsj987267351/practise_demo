package month10.day27;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/description/?envType=daily-question&envId=2023-10-27
 * @date 2023/10/27 11:37
 */
public class demo1 {
    int mod = (int) (1e9 + 7);

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
//        找到最大间距得宽和高即可
        int HLength = horizontalCuts.length;
        int WLength = verticalCuts.length;
        int MaxH = horizontalCuts[0], MaxW = verticalCuts[0];
        for (int i = 1; i < HLength; i++) {
            MaxH = Math.max(MaxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        MaxH = Math.max(MaxH, h - horizontalCuts[HLength - 1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            MaxW = Math.max(MaxW, verticalCuts[i] - verticalCuts[i - 1]);
        }
        MaxW = Math.max(MaxW, w - verticalCuts[WLength - 1]);
        long res = (long)MaxH * MaxW;
        return (int) (res % mod);
    }
}

