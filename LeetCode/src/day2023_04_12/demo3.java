package day2023_04_12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/que-shi-de-shu-zi-lcof
 * @date 2023/4/12 19:02
 */
public class demo3 {
    public int missingNumber1(int[] nums) {
        int[] ints = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]] = 1;
        }

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (nums[mid] == mid){
                i = mid+1;
            }else {
                j = mid-1;
            }
        }
        return i;
    }
}

