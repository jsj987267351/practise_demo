package month11.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/16 11:47
 */
public class demo1 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int length = nums.length;
        int i = 0, res = 0;
        while (i < length) {
            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                i++;
                continue;
            }
            int start = i;
            i++;
            while (i < length && nums[i] <= threshold && nums[i] % 2 != nums[i - 1] % 2) {
                i++;
            }
            res = Math.max(res, i - start);
        }
        return res;
    }
}

