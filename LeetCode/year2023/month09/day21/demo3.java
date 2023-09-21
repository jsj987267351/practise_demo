package month09.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/missing-number-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/21 13:49
 */
public class demo3 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res =(n * (n+1)) / 2;
        for (int num : nums) {
            res-=num;
        }
        return res;
    }
}

