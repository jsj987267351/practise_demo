package month07.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/maximum-split-of-positive-even-integers/
 * @date 2023/7/6 13:25
 */
public class demo1 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 == 1) {
            return res;
        }

//        贪心算法，从2，4，6--一直加下去，如果剩余的数字不足以继续拆分，直接将最后两个数字合并即可

        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        if (finalSum == 0) {
//            代表刚好拆完
            return res;
        }
        int size = res.size();
        Long last = res.get(size - 1);
        res.remove(size - 1);
        res.add(last + finalSum);

        return res;
    }
}

