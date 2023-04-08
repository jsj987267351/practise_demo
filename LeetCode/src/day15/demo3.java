package day15;

import java.util.HashMap;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * @date 2023/4/2 20:45
 * https://leetcode.cn/problems/majority-element/
 */
public class demo3 {
    public int majorityElement1(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if (integer == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], integer + 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
       int result = nums[0];
       int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result){
                count++;
            }else if (count ==0){
                result = nums[i];
            }else {
                count--;
            }
        }
        return result;
    }
}

