package LeetCode.month06.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/17 13:50
 */
public class demo2 {
    public int jump(int[] nums) {
        int res = 0, curCover = 0, maxCover = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxCover = Math.max(maxCover, i + nums[i]);
            if (i == curCover) {
                res++;
                curCover = maxCover;
            }
        }
        return res;
    }
}

