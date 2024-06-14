package LeetCode.month06.day12.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/12 13:29
 */
public class demo3 {

    TreeNode pre;
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == null) {
            pre = root;
        } else {
            res = Math.min(res, root.val - pre.val);
            pre = root;
        }
        dfs(root.right);
    }
}

