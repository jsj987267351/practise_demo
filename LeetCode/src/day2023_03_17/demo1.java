package day2023_03_17;

import java.util.Arrays;

public class demo1 {
    /**
     * 存在重复元素
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false
     *  https://leetcode.cn/problems/contains-duplicate/
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}

//        for (int i = 0; i < nums.length - 1; i++) {
//            int min = i;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] < nums[min]) {
//                    min = j;
//                }
//            }
//            int temp = 0;
//            temp = nums[min];
//            nums[min] = nums[i];
//            nums[i] = temp;
//        }
//
//        for (int i = 0; i < nums.length-1; i++) {
//            if(nums[i] == nums[i+1]){
//                return true;
//            }
//        }
//        return false;
//    }


