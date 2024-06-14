package LeetCode.month06.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/14 14:35
 */
public class demo5 {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int res = 1, preDiff = 0, curDiff = 0;
        for (int i = 1; i < len; i++) {
            curDiff = nums[i] - nums[i - 1];
            if (curDiff > 0 && preDiff <= 0 || curDiff < 0 && preDiff >= 0) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }
}

