package LeetCode.month01.day31;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/31 10:58
 */
public class demo {
    public int[] distinctDifferenceArray(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
            res[i] = set.size();
        }
        set.clear();
        for (int i = len - 2; i >= 0; i--) {
            set.add(nums[i + 1]);
            res[i] -= set.size();
        }
        return res;
    }

    public int[] distinctDifferenceArray1(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Set<Integer> preSet, lateSet;
        for (int i = 0; i < len; i++) {
            preSet = new HashSet<>();
            lateSet = new HashSet<>();
            for (int j = i; j >= 0; j--) {
                preSet.add(nums[j]);
            }
            for (int j = i + 1; j < len; j++) {
                lateSet.add(nums[j]);
            }
            res[i] = preSet.size() - lateSet.size();
        }
        return res;
    }
}

