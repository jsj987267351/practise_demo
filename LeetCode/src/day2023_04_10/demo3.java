package day2023_04_10;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * @date 2023/4/10 16:49
 */
public class demo3 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result2 = new ArrayList<>();
        int[] ints = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            ints[nums1[i]] = 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (ints[nums2[i]] == 1 && !result2.contains(nums2[i])) {
                result2.add(nums2[i]);
            }
        }
        int[] result = new int[result2.size()];
        int i = 0;
        for (Integer integer : result2) {
            result[i] = integer;
            i++;
        }
        return result;
    }
}

