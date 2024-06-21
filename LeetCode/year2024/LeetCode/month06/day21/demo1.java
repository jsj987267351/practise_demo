package LeetCode.month06.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 9:25
 */
public class demo1 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int len = temperatureA.length;
        int res = 0, cur = 0;
        for (int i = 1; i < len; i++) {
            int diffA = temperatureA[i] - temperatureA[i - 1];
            int diffB = temperatureB[i] - temperatureB[i - 1];
            if (diffA > 0 && diffB > 0 || diffA < 0 && diffB < 0 || diffA == 0 && diffB == 0) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 0;
            }
        }
        return Math.max(res, cur);
    }
}

