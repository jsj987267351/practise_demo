package LeetCode.month06.day10;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/10 17:24
 */
public class demo9 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0, len = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = nums3[i] + nums4[j];
                if (map.containsKey(-sum)) {
                    res += map.get(-sum);
                }
            }
        }
        return res;
    }
}

