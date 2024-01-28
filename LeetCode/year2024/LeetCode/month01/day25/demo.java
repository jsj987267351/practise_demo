package LeetCode.month01.day25;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/25 10:40
 */
public class demo {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                res += nums.get(i);
            }
        }
        return res;
    }
}

