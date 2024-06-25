package LeetCode.month06.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/25 10:48
 */
public class demo5 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalDiff = 0, curDiff = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            curDiff += gas[i] - cost[i];
            totalDiff += gas[i] - cost[i];
            if (curDiff < 0) {
                index = i + 1;
                curDiff = 0;
            }
        }
        return totalDiff < 0 ? -1 : index % gas.length;
    }
}

