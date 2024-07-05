package LeetCode.month07.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/5 9:29
 */
public class demo2 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 3) return len;
        int res = 2, index = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] != nums[index]) {
                nums[res] = nums[i];
                res++;
                index++;
            }
        }
        return res;
    }
}

