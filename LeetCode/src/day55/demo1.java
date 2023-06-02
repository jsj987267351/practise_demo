package day55;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/2 15:24
 */
public class demo1 {
    public int longestConsecutive1(int[] nums) {
//        利用set集合先去重，先将num数组存入set集合。遍历是首先查看该元素的前一值是否存在，如果存在说明该元素不是起始元素，直接跳过
//        如果不存在，说明该元素是起始元素，进入while循环，找到该院色的最长序列。然后判断更新
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
//            不存在时才能进入，说明该元素时第一个元素
            if (!set.contains(num - 1)) {
                int currentSum = 1;
                int temp = num;
                while (set.contains(++temp)) {
                    currentSum++;
                }
//                更新
                result = Math.max(result, currentSum);
            }
        }
        return result;
    }


    public int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
//    直接sort试下时间与空间复杂度
        Arrays.sort(nums);
        int max = 0;
        int currentMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
//                相邻
                currentMax++;
            } else if (nums[i] == nums[i-1]){
                continue;
            }else {
                max = Math.max(max, currentMax);
                currentMax = 1;
            }
        }
        max = Math.max(max, currentMax);
        return max;
    }
}

