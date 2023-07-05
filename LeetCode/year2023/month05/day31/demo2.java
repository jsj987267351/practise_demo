package month05.day31;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 打家劫舍 II
 * https://leetcode.cn/problems/house-robber-ii/
 * @date 2023/5/31 15:25
 */
public class demo2 {
    public int rob(int[] nums) {
//        整体思路，将整个环表分为0-n-1  和0-n 两个链表分别计算
        int length = nums.length;

        if (length == 1 ) {
            return nums[0];
        }else if (length==2){
            return Math.max(nums[0],nums[1]);
        }

//        0- n-1 可偷范围
        int[] dp1 = new int[length - 1];
//        1- n 可偷范围
        int[] dp2 = new int[length - 1];

        dp1[0] = nums[0];
        dp1[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }

        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < length - 1; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i + 1], dp2[i - 1]);
        }

        return Math.max(dp1[length - 2], dp2[length - 2]);
    }
}

