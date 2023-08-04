package month08.day02;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/8/2 14:49
 */
public class demo1 {
    public int flipgame(int[] fronts, int[] backs) {
//        脑筋急转弯
//        只要不是正反两面是相同的数字，那么就可以通过反转将其反转到另一面
//        所以要求是找到一个数字，这个数字只在一面出现过，并且是最小值
        Set<Integer> set = new HashSet<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        for (int front : fronts) {
            if (!set.contains(front)) {
                res = Math.min(res, front);
            }
        }
        for (int back : backs) {
            if (!set.contains(back)) {
                res = Math.min(res, back);
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

