package LeetCode.month07.day12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/12 10:34
 */
public class demo6 {
    public int findMaximumXOR(int[] nums) {
        int res = 0, mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int mayBeResult = res | (1 << i);
            for (Integer key : set) {
                if (set.contains(key ^ mayBeResult)){
                    res = mayBeResult;
                    break;
                }
            }
        }
        return res;
    }
}

