package LeetCode.month07.day03;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/3 10:30
 */
public class demo7 {
    public int smallestDifference(int[] a, int[] b) {
        long res = Integer.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);
        int indexA = 0, indexB = 0;
        long temp;
        while (indexA < a.length && indexB < b.length) {
            temp = a[indexA] - b[indexB];
            res = Math.min(res, Math.abs(temp));
            if (a[indexA] < b[indexB]) {
                indexA++;
            } else {
                indexB++;
            }
        }
        return (int) res;
    }
}

