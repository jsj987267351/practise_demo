package LeetCode.month03.day27;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/27 14:03
 */
public class demo {
    public int countWays(int[][] ranges) {
//        强制将有交集的先分组，得到总组数sum   1_000_000_007
//        总共有sum个组，每两个组组合一共有2的sum次方组合
        Arrays.sort(ranges, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int pre = ranges[0][1], res = 2;
        for (int i = 1; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = ranges[i][1];
            if (start > pre) {
                res = (res * 2) % 1_000_000_007;
            }
//            更新右区见
            pre = Math.max(pre, end);
        }
        return res;
    }
}

