package LeetCode.month01.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/28 13:17
 */
public class demo {
    //    看官网解析,额外用大桶接水，不一定非要将过程中的水一直放在这两个杯子里
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
//        放不下这么多水
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        return targetCapacity % help(jug1Capacity, jug2Capacity) == 0;
    }

    public int help(int a, int b) {
        int min = Math.min(a, b);
        for (int i = min; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}

