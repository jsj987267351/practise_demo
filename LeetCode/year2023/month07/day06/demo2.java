package month07.day06;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/6 13:50
 */
public class demo2 {
    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
//        动态规划：dp[i]表示长度为i时的最长连续递增
        int[] dp = new int[length];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
//            只要当前值比前一个值大，那么他们就是连续的，就可以在前一个的长度上+1
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
//                如果不是，说明该连续断了，就要更新最大值，然后重新开始计算
                max = Math.max(max, dp[i - 1]);
            }
        }
//        最后在更新一下，因为最后有可能一直连续到最后的是最大值
        return Math.max(max, dp[length - 1]);
    }
}

