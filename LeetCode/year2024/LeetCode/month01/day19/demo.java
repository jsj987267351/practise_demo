package LeetCode.month01.day19;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/19 11:42
 */
public class demo {
    public long minimumRemoval(int[] beans) {
        long res = Long.MIN_VALUE;
        Arrays.sort(beans);
        int length = beans.length;
        long sum = 0;
        for (int i = 0; i < length; i++) {
            sum += beans[i];
            res = Math.max(res, (long)(length - i) * beans[i]);
        }
        return sum - res;
    }
}

