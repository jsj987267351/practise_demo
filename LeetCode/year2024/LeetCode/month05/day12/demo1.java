package LeetCode.month05.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/12 10:53
 */
public class demo1 {
    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] <= 0) continue;
            res ++;
            for (int j = i + 1; j < batteryPercentages.length; j++) {
                batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
            }
        }
        return res;
    }
}

