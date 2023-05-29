package day52;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/find-pivot-index/
 * @date 2023/5/29 15:47
 */
public class demo2 {
    public int pivotIndex(int[] nums) {
//        总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
//        如果当前值的左边和等于右边和则返回，因为自左向右遍历，所以返回的是左边的，满足题目要求
//        左面和为sumTemp，右边和为sum - sumTemp - nums[i]  即 sumTemp =  sum - sumTemp - nums[i], 即2* sumTemp + nums[i] =sum
        int sumTemp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sumTemp + nums[i] == sum) {
                return i;
            }
            sumTemp += nums[i];
        }
        return -1;
    }
}

