package day45;


import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/17 16:38
 */
public class demo1 {
    public boolean isStraight1(int[] nums) {
//        先统计大小王的数量，然后从非0的第二张牌进行遍历。遇到相同或小王不够填补两个数字之间的差距就返回false，否则就将大小王数量减去二者之间的差距
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }
        }
        for (int i = zero + 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > zero + 1 || nums[i] == nums[i - 1]) {
                return false;
            } else {
                zero -= nums[i] - nums[i - 1] - 1;
            }
        }
        return true;
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[zero] <5;
    }
}

