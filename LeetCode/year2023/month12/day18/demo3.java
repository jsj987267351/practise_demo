package month12.day18;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/18 14:38
 */
public class demo3 {
    public int smallestDifference(int[] a, int[] b) {
        long res = Long.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);
        int index1 = 0, index2 = 0;
        long diff = 0;
        while (index1 < a.length && index2 < b.length) {
            diff = a[index1] - b[index2];
            res = Math.min(res, Math.abs(diff));
            if (diff < 0) {
                index1++;
            } else {
                index2++;
            }
        }
        return (int) res;
    }
}

