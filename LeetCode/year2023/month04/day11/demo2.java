package month04.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 统计一个数字在排序数组中出现的次数。
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @date 2023/4/11 17:33
 */
public class demo2 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int n = 0;
        int temp = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (nums[m] > target) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                n = m;
                j = m - 1;
            }
        }
        if (nums[n] != target) {
            return 0;
        }
        int k = n;
        for (; n < nums.length; n++) {
            if (nums[n] != target) {
                temp = n;
                break;
            }
        }
        if (n == nums.length) {
            return n - k;
        }

        return temp - k;
    }
}

