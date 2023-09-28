package month09.day28;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/28 16:56
 */
public class demo1 {
    public int majorityElement1(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        int count = 1;
//        士兵打仗同理，如果存在结果，那么每两个不同的数字抵消后最终剩余的数字一定是结果
        for (int i = 1; i < len; i++) {
            if (nums[i] == res) {
                count++;
            } else if (count == 0) {
                res = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
//        此时的res就是有可能为最终结果的值,然后就是判断是否为最终结果
        count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == res) {
                count++;
            }
        }
        return count > len / 2 ? res : -1;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
//        如果存在的话，那么排序后中间的数字一定是结果
        int len = nums.length;
        int res = nums[len / 2];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == res) {
                count++;
            }
        }
        return count > len / 2 ? res : -1;
    }
}

