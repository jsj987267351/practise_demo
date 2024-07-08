package LeetCode.month07.day08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/8 10:33
 */
public class demo7 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] * nums[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count > 1) {
                res += count * (count - 1) * 4;
            }
        }
        return res;
    }
}

