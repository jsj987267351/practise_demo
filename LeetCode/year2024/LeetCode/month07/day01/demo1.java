package LeetCode.month07.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/1 9:28
 */
public class demo1 {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int res = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
//                这里没有用前面更新dp是因为题目要求是求子数组，而不是子序列，要求连续，所以不等的话
//                那么以当前为底长度就是0
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}

