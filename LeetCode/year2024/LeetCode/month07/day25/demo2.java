package LeetCode.month07.day25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/25 9:41
 */
public class demo2 {
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (!map.containsKey(nums.get(i))) {
                map.put(nums.get(i), new ArrayList<>());
            }
            map.get(nums.get(i)).add(i);
        }
        int len = nums.size();
        int res = len;
        for (List<Integer> value : map.values()) {
            int max = len - value.get(value.size() - 1) + value.get(0);
            for (int i = 1; i < value.size(); i++) {
                max = Math.max(max, value.get(i) - value.get(i - 1));
            }
            res = Math.min(res, max);
        }
        return res / 2;
    }
}

