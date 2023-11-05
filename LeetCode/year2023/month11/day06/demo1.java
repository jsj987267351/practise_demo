package month11.day06;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/5 15:51
 */
public class demo1 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num -1)){
                int curMax = 1;
                while (set.contains(++num)){
                    curMax++;
                }
                res = Math.max(res,curMax);
            }
        }
        return res;
    }

    public int longestConsecutive2(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        Arrays.sort(nums);
        int res = 1, curmax = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                curmax++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                res = Math.max(res, curmax);
                curmax = 1;
            }
        }
        res = Math.max(res, curmax);
        return res;
    }

    public int longestConsecutive1(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        Arrays.sort(nums);
        int[] dp = new int[length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1];
            } else if (nums[i] == nums[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

