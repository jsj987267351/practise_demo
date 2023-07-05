package month06.day06;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&envId=top-100-liked
 * @date 2023/6/6 13:57
 */
public class demo1 {
    public int subarraySum1(int[] nums, int k) {
//        前缀和,其中前缀和数组中数值的含义是对应下标前面所有（不包括本身）数值的和
        int length = nums.length;
        int[] preSum = new int[length + 1];
        int result = 0;
        preSum[0] = 0;
        for (int i = 0; i < length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        for (int left = 0; left < length; left++) {
            for (int right = left; right <length ; right++) {
//                计算left到right中间值的总和
               if (preSum[right+1] - preSum[left] ==k){
                   result++;
               }
            }
        }
        return result;
    }

    public int subarraySum(int[] nums, int k) {
//        前缀和+哈希表
//        key值为前缀和，value为出现的次数
        Map<Integer,Integer> map = new HashMap<>();
//        前缀和为0的出现次数为1，因为有可能遍历到的数字本身为k
        map.put(0,1);
        int result = 0;
        int sum = 0;
        for (int num : nums) {
//            当前前缀和
            sum+=num;
//            去hash表查找是否有前缀和为sum - k   因为设置sum-k = x的话  即为sum - x = k；即为两个前缀和中间差值为k，满足条件
            if (map.containsKey(sum - k)){
                result+=map.get(sum-k);
            }
//            存入当前前缀和
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return result;
    }
}

