package month05.day18;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * https://leetcode.cn/problems/third-maximum-number/
 * @date 2023/5/18 14:39
 */
public class demo1 {
    public int thirdMax1(int[] nums) {
//        排序，从后往前遍历。遇到不同的数字就将grade++，其中grade代表的含义是找到第几大的值，当grade=3时代表已经找到了
//        需要注意的是，遍历中要判断索引是否越界，越界的代表到头了还没找到，所以直接break
        Arrays.sort(nums);
        int grade = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (grade == 3) {
                return nums[i];
            }
            if (i - 1 < 0) {
                break;
            }
            if (nums[i] != nums[i - 1]) {
                grade++;
            }
        }
        return nums[nums.length - 1];
    }

    public int thirdMax(int[] nums) {
//        最大值 次大值 第三大
        long one = Long.MIN_VALUE, two = Long.MIN_VALUE, three = Long.MIN_VALUE;
        for (int num : nums) {
//            根据数值所在区间更新三个值
            if (num > one) {
                three = two;
                two = one;
                one = num;
            } else if (num < one && num > two) {
                three = two;
                two = num;
            } else if (num < two && num > three) {
                three = num;
            }
        }
        return three == Long.MIN_VALUE ? (int) one : (int) three;
    }
}

