package LeetCode.month06.day19.demo6;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/19 11:19
 */
public class demo {
    public int rob(TreeNode root) {
        int[] dp = dfs(root);
//        0偷  1不偷
        return Math.max(dp[0], dp[1]);
    }


    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] leftDp = dfs(root.left);
        int[] rightDp = dfs(root.right);
        int[] dp = new int[2];
        dp[0] = root.val + leftDp[1] + rightDp[1];
        dp[1] = Math.max(leftDp[0], leftDp[1]) + Math.max(rightDp[0], rightDp[1]);
        return dp;
    }
}

