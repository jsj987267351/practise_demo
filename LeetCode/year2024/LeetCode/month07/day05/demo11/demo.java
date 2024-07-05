package LeetCode.month07.day05.demo11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/5 11:00
 */
public class demo {
    TreeNode pre;
    TreeNode res;

    public TreeNode convertBiNode(TreeNode root) {
        res = new TreeNode(-1);
        dfs(root);
        return res.right;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            if (pre == null){
                pre = root;
                res.right = pre;
            }else {
                pre.right = root;
                pre = pre.right;
            }
            pre.left = null;
            dfs(root.right);
        }
    }
}

