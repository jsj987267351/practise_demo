package LeetCode.month07.day16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/16 9:29
 */
public class demo1 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int count1 = 0, count2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int num : nums2) {
            if (set.contains(num)){
                count2++;
            }
        }
        set.clear();
        for (int i : nums2) {
            set.add(i);
        }
        for (int num : nums1) {
            if (set.contains(num)){
                count1++;
            }
        }
        return new int[]{count1, count2};
    }
}

