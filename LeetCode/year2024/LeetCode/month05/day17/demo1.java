package LeetCode.month05.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/17 11:39
 */
public class demo1 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;
        List<int[]> list = new ArrayList<>(difficulty.length);
        for (int i = 0; i < difficulty.length; i++) {
            list.add(new int[]{difficulty[i], profit[i]});
        }
        Collections.sort(list, (a, b) -> b[1] - a[1]);
        for (int i = 0; i < worker.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j)[0] <= worker[i]) {
                    res += list.get(j)[1];
                    break;
                }
            }
        }
        return res;
    }
}

