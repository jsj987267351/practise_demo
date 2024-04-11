package LeetCode.month04.day08;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/8 11:37
 */
public class demo {
    public int minOperations(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        Arrays.sort(nums);
//        原地去重,因为要求数组连续中不能有重复数字，也就是说重复数字是一定会被修改的。前index都是去重后的数字，也就是可能不会被修改的数字
        int index = 0;
        for (int i = 1; i < len; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
//        此res是指不用修改数字最大长度
        int res = 0;
//        使数组连续，也就是使数组中的最大值与最小值的差值为len - 1，并且数字不能重复
//        设数组的最小值为left，因为数组长度为len，所以最大值为 right = left + len -1
//        所以所有在此区间内的数字都不需要改变，因此这里枚举left的情况
        for (int i = 0; i < index; i++) {
//            每个数字作为left的情况，因为是有序的，所以可以使用二分,max是以left下标数字为最小值的话的最大值
            int left = i, right = index, max = nums[left] + len - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (nums[mid] <= max) {
//                    说明该数字在区间内
                    left = mid + 1;
                } else {
//                    说明该数字不在区间内
                    right = mid - 1;
                }
            }
//            此时的left是第一个不在区间内的数字，也就是说[i,left-1]之间的数字都是不用修改的，长度为 left - 1 -i +1 = left - i, 因此更新最大值
            res = Math.max(res, left - i);
        }
        return len - res;
    }
}

