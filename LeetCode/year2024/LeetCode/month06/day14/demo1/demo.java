package LeetCode.month06.day14.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/14 14:16
 */
public class demo {
    int pre = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        root.val += pre;
        pre = root.val;
        dfs(root.left);
    }
}

