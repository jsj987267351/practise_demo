package LeetCode.month06.day17.demo6;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/17 14:18
 */
public class demo {
    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
}

