package LeetCode.month02.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/28 13:06
 */
public class demo {
    public int minIncrements(int n, int[] cost) {
        int res = 0;
        for (int i = cost.length / 2; i > 0; i--) {
            res += Math.abs(cost[i * 2 - 1] - cost[i * 2]);
            cost[i - 1] = cost[i - 1] + Math.max(cost[i * 2 - 1], cost[i * 2]);
        }
        return res;
    }
}

