package month04.day14;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * https://leetcode.cn/problems/missing-number/
 * @date 2023/4/14 15:09
 */
public class demo4 {
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] !=i){
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber(int[] nums) {
        int[] ints = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
           ints[nums[i]] = 1;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0){
                return i;
            }
        }
        return ints.length;
    }
}

