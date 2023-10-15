package month10.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/jump-game-ii/?envType=list&envId=hliQiQFH
 * @date 2023/10/15 13:49
 */
public class demo2 {
    public int jump(int[] nums) {
        int res = 0;
        int curCover = 0, maxCover = 0;
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

