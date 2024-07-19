package LeetCode.month07.day19;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/19 10:01
 */
public class demo3 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        long res = Long.MIN_VALUE;
        for (int i = 0; i < beans.length; i++) {
            sum += beans[i];
            res = Math.max(res, (long) (beans.length - i) * beans[i]);
        }
        return sum - res;
    }
}

