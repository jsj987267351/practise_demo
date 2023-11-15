package month11.day15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/15 14:55
 */
public class demo4 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return res;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        if (finalSum == 0) {
            return res;
        }
        Long remove = res.remove(res.size() - 1);
        res.add(finalSum + remove);
        return res;
    }
}

