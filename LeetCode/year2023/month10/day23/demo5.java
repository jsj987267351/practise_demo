package month10.day23;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/23 13:15
 */
public class demo5 {
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int res = Integer.MIN_VALUE;
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int index = findIndex(nums, res, num);
            nums[index] = num;
            if (index == res) {
                res++;
            }
        }
        return res;
    }

    public int findIndex(int[] nums, int right, int value) {
        int left = -1;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < value) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}

