package day71;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/gas-station/
 * @date 2023/6/27 13:01
 */
public class demo2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
//        当前油差的总和
        int currentSum = 0;
//        总体油差总和
        int totalSum = 0;
//        开始索引
        int index = 0;

        int length = gas.length;

        for (int i = 0; i < length; i++) {
//            计算当前油差与总体油差
            currentSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
//            如果当前油差小于0，代表从当前前面任意位置走到当前位置油都不够，所以将起始位置设置为下一个加油站，并且当前油差归0
            if (currentSum < 0) {
                index = (i + 1) % length;
                currentSum = 0;
            }
        }
//        如果总体油差小于0，说明从任何位置走都不行，直接返回-1
//        如果大于0，说明一定有解，我们记录的index就是解
        if (totalSum < 0) return -1;

        return index;
    }
}

