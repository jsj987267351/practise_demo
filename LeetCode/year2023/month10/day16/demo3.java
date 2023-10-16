package month10.day16;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/third-maximum-number/?envType=list&envId=RxT23Yqb
 * @date 2023/10/16 13:09
 */
public class demo3 {
    public int thirdMax1(int[] nums) {
        Arrays.sort(nums);
        int differentNum = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                differentNum++;
            }
            if (differentNum == 3) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public int thirdMax(int[] nums) {
        long First = Long.MIN_VALUE, Second = Long.MIN_VALUE, Third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > First) {
                Third = Second;
                Second = First;
                First = num;
            } else if (num < First && num > Second) {
                Third = Second;
                Second = num;
            } else if (num < Second && num > Third) {
                Third = num;
            }
        }
        return (int) (Third == Long.MIN_VALUE ? First : Third);
    }
}

