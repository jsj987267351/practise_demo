package LeetCode.month01.day24;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/24 12:18
 */
public class demo {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long res = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
//            以当前下标为山峰
            int cur = maxHeights.get(i);
            long tempSum = cur;
//            左
            for (int j = i - 1; j >= 0; j--) {
                cur = Math.min(cur, maxHeights.get(j));
                tempSum += cur;
            }
//            右
            cur = maxHeights.get(i);
            for (int j = i + 1; j < maxHeights.size(); j++) {
                cur = Math.min(cur, maxHeights.get(j));
                tempSum += cur;
            }
            res = Math.max(res, tempSum);
        }
        return res;
    }
}

