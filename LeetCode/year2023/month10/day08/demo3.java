package month10.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/house-robber-ii/?envType=list&envId=RxT23Yqb
 * @date 2023/10/8 12:27
 */
public class demo3 {
    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dpFirst = new int[len - 1];
        int[] dpLast = new int[len - 1];
        dpFirst[0] = nums[0];
        dpFirst[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len - 1; i++) {
            dpFirst[i] = Math.max(dpFirst[i - 1], dpFirst[i - 2] + nums[i]);
        }

        dpLast[0] = nums[1];
        dpLast[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < len - 1; i++) {
            dpLast[i] = Math.max(dpLast[i - 1], dpLast[i - 2] + nums[i + 1]);
        }

        return Math.max(dpFirst[len - 2], dpLast[len - 2]);
    }
}

