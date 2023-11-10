package month11.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/10 14:27
 */
public class demo5 {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length == 1) return 1;
        int preDiff = 0, curDiff = 0;
        int res = 1;
        for (int i = 1; i < length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if (curDiff > 0 && preDiff <= 0 || curDiff < 0 && preDiff >= 0) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }
}

