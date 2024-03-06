package LeetCode.month03.day06;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/6 14:05
 */
public class demo {
    public int findKOr(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if (((num >> i) & 1) != 0) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
        }
        int res = 0;
        for (int key : map.keySet()) {
            if (map.get(key) >= k) {
                res |= 1 << key;
            }
        }
        return res;
    }

    public int findKOr1(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            int count = 0;
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            if (count >= k) {
                res |= 1 << i;
            }
        }
        return res;
    }
}

