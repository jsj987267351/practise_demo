package LeetCode.month06.day10;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/10 16:16
 */
public class demo1 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num + 1)) {
                int cur = 1;
                while (set.contains(--num)) {
                    cur++;
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}

