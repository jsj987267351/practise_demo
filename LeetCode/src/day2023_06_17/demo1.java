package day2023_06_17;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/17 18:51
 */
public class demo1 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
//        用map集合统计前两个数组所有和以及出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
//        接着遍历后两个数组中的所有和，并且从map集合中找需要的数字
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (map.containsKey(0 - nums3[i] - nums4[j])){
                    res+=map.get(0 - nums3[i] - nums4[j]);
                }
            }
        }
        return res;
    }
}

