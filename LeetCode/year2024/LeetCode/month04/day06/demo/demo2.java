package LeetCode.month04.day06.demo;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/6 18:56
 */
public class demo2 {
    private int res;

    public int maxAncestorDiff(TreeNode root) {
        int[] dp = DFS(root);
        return Math.max(res, Math.max(dp[0] - root.val, root.val - dp[1]));
    }

    //    方法返回root节点的左右子树的最大值和最小值，0为最大值，1为最小值
    public int[] DFS(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
        int[] left = DFS(root.left);
        int[] right = DFS(root.right);
        int max = Math.max(root.val, Math.max(left[0], right[0]));
        int min = Math.min(root.val, Math.min(left[1], right[1]));
        res = Math.max(res,Math.max(max - root.val,root.val - min));
        return new int[]{max, min};
    }
}

