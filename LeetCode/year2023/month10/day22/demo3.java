package month10.day22;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/jump-game/?envType=list&envId=hliQiQFH
 * @date 2023/10/22 12:18
 */
public class demo3 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int cover = nums[0];
        for (int i = 1; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

