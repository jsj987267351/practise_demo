package day58;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/product-of-array-except-self
 * @date 2023/6/6 14:59
 */
public class demo2 {
    public int[] productExceptSelf1(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int zeroCount = 0;
        int zeroIndex = 0;
        int sum = 1;
//        先判断0的个数，如果只有一个0的话，那么除了0位置上的其他位置都为0  如果有两个，那么全为0
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            }
        }

        if (zeroCount > 1) {
            return result;
        } else if (zeroCount == 1) {
            for (int i = 0; i < length; i++) {
                if (i == zeroIndex) continue;
                sum *= nums[i];
            }
            result[zeroIndex] = sum;
            return result;
        } else {
//            前缀积
            int[] pre = new int[length];
//            后缀积
            int[] after = new int[length];
            pre[0] = 1;
            after[length - 1] = 1;
            for (int i = 1; i < length; i++) {
                pre[i] = pre[i - 1] * nums[i - 1];
            }
            for (int i = length - 2; i >= 0; i--) {
                after[i] = after[i + 1] * nums[i + 1];
            }
            for (int i = 0; i < length; i++) {
                result[i] = pre[i] * after[i];
            }
            return result;
        }
    }

    //    直接使用前缀积和后缀积
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
//            前缀积
        int[] pre = new int[length];
//            后缀积
        int[] after = new int[length];
        pre[0] = 1;
        after[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            after[i] = after[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            result[i] = pre[i] * after[i];
        }
        return result;
    }

    //      在结果原数组上直接进行前缀积和后缀及积的运算，减少空间复杂度
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
//        首先计算前缀积
//        0下标左边没有元素，所以前缀积为1
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
//        计算后缀积
//        开始后缀总积为1，因为从length-1开始遍历，最后一位只有前缀积
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
//            后缀积为当前值*后续积，因为当前值已经是前缀积
            result[i] = result[i] * R;
//            注意这里是使用原数组进行更新，因为结果数组已经为前缀积，无法得出后缀积
            R *= nums[i];
        }
        return result;
    }
}

