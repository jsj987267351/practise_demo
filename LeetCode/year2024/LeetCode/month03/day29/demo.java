package LeetCode.month03.day29;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/29 11:44
 */
public class demo {
    public int minimumSum(int[] nums) {
        int length = nums.length;
        int[] pre = new int[length];
        pre[0] = Integer.MAX_VALUE;
        int[] lat = new int[length];
        lat[length - 1] = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            pre[i] = Math.min(pre[i - 1], nums[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            lat[i] = Math.min(lat[i + 1], nums[i + 1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (pre[i] < nums[i] && nums[i] > lat[i]) {
                res = Math.min(res, pre[i] + nums[i] + lat[i]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

