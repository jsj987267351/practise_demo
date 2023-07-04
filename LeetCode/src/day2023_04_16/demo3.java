package day2023_04_16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/range-sum-query-immutable/
 * @date 2023/4/16 20:06
 */
public class demo3 {

    class NumArray1 {
        int [] array;

        public NumArray1(int[] nums) {
            array = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i < right+1; i++) {
                sum+=array[i];
            }
            return sum;
        }
    }


    class NumArray {
        int [] array;

        public NumArray(int[] nums) {
            array = new int[nums.length+1];
            array[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                array[i] = nums[i] + array[i-1];
            }
        }

        public int sumRange(int left, int right) {
            if (left ==0){
                return array[right];
            }
            return array[right] - array[left-1];
        }
    }

}

