package LeetCode.month07.day23;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/23 9:29
 */
public class demo2 {
    public int alternatingSubarray(int[] nums) {
        int res = -1, start = 0, end = 0;
        while (end < nums.length -1) {
            if (nums[end] + 1 != nums[end + 1]) {
                end++;
                continue;
            }
            start = end;
            end += 2;
            while (end < nums.length && nums[end] == nums[start] + (end - start) % 2) {
                end++;
            }
            res = Math.max(res, end - start);
            end--;
        }
        return res;
    }
}

