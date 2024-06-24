package LeetCode.month06.day24.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/24 10:11
 */
public class demo {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        backtracking(root);
        return res;
    }

    public int backtracking(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(backtracking(root.left), 0);
        int right = Math.max(backtracking(root.right), 0);
        res = Math.max(res, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}

