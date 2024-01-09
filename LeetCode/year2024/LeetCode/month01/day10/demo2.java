package LeetCode.month01.day10;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/9 14:35
 */
public class demo2 {
    public int findMaximumXOR(int[] nums) {
        int res = 0, mask = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            set.clear();
            for (int num : nums) {
                set.add(num & mask);
            }
            int temp = res | (1 << i);
            for (int cur : set) {
                if (set.contains(cur ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}

