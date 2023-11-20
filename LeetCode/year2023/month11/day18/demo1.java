package month11.day18;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/18 13:55
 */
public class demo1 {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int num : nums) {
            int help = help(num);
            if (!map.containsKey(help)) {
                map.put(help, num);
                continue;
            }
            res = Math.max(res, map.get(help) + num);
            if (num > map.get(help)) {
                map.put(help, num);
            }
        }
        return res;
    }

    public int help(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num = num / 10;
        }
        return res;
    }
}

