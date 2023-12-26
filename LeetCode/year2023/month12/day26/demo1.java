package month12.day26;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/26 12:20
 */
public class demo1 {
    public String[] findLongestSubarray(String[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, max = 0, sum = 0;
        map.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            sum += array[i].charAt(0) >= 'A' ? 1 : -1;
//            左开右闭
            if (map.containsKey(sum)) {
                int index = map.get(sum);
                if (i - index > max) {
                    max = i - index;
                    start = index +1;
                }
            } else {
                map.put(sum, i);
            }
        }
        String[] res = new String[max];
        for (int i = start; i < start + max; i++) {
                res[i - start] = array[i];
        }
        return res;
    }
}

