package LeetCode.month07.day23;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/23 9:45
 */
public class demo3 {
    public long maximumSumOfHeights(int[] heights) {
        long res = 0;
        for (int i = 0; i < heights.length; i++) {
            int cur = heights[i];
            long tmp = cur;
            for (int left = i - 1; left >= 0; left--) {
                cur = Math.min(cur, heights[left]);
                tmp += cur;
            }
            cur = heights[i];
            for (int right = i + 1; right < heights.length; right++) {
                cur = Math.min(cur, heights[right]);
                tmp += cur;
            }
            res = Math.max(res,tmp);
        }
        return res;
    }
}

