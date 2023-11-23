package month11.day23.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/23 12:48
 */
public class demo3 {
    public int rob(TreeNode root) {
        int[] dp = help(root);
//        0：偷 ，1：不偷
        return Math.max(dp[0], dp[1]);
    }

    public int[] help(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = help(root.left);
        int[] right = help(root.right);
        int[] dp = new int[2];
        dp[0] = root.val + left[1] + right[1];
        dp[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return dp;
    }
}

