package month11.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/15 14:30
 */
public class demo2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0, sum = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (cur < 0) {
                index = i + 1;
                cur = 0;
            }
        }
        return sum < 0 ? -1 : index;
    }
}

