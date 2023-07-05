package month05.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/can-place-flowers
 * @date 2023/5/16 15:28
 */
public class demo1 {
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int sum = 0;
        int[] ints = new int[flowerbed.length + 2];
        ints[0] = 0;
        ints[ints.length - 1] = 0;
        for (int i = 0, j = 1; i < flowerbed.length; i++, j++) {
            ints[j] = flowerbed[i];
        }
        for (int i = 1; i < ints.length - 1; i++) {
            if (ints[i] == 0 && ints[i - 1] == 0 && ints[i + 1] == 0) {
                sum++;
                ints[i] = 1;
            }
        }
        return sum >= n;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int sum = 0, count = 1;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                sum++;
                count = 1;
            }
        }
        if (count == 2) {
            sum++;
        }
        return sum >= n;
    }

    //  跳格子
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; ) {
//            当前位置已经种植，所以下一个格子也不可种植，直接跳两格
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
//                因为是跳格子，所以前一位置一定为0，并且当前位置未种植，下一位置也未种植，所以当前位置可种植.多判断是否到达了尾部，因为尾部的有边界默认为0
                n--;
//                判断是否已经达到条件了
                if (n == 0) {
                    return true;
                }
//                因为当前位置已经种植了，所以下一位置不可种植，跳两格
                i += 2;
            } else {
//                当前为0.下一为1,所以下下也不可种植。所以跳三格
                i += 3;
            }
        }
        return false;
    }
}

