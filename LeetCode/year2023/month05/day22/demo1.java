package month05.day22;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * https://leetcode.cn/problems/max-consecutive-ones/
 * @date 2023/5/22 17:20
 */
public class demo1 {
    public int findMaxConsecutiveOnes(int[] nums) {
//        计算每一段1的长度，遇到0就更新最大值。
//        注意：最后需要在更新一次max
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        max = Math.max(max,temp);
        return max;
    }
}

