package month11.day08.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/8 13:22
 */
public class demo4 {
    TreeNode pre;
    int res;

    public int getMinimumDifference(TreeNode root) {
        res = Integer.MAX_VALUE;
        pre = null;
        help(root);
        return res;
    }

    public void help(TreeNode root) {
        if (root != null) {
            help(root.left);
            if (pre == null) {
                pre = root;
            } else {
                res = Math.min(res, Math.abs(root.val - pre.val));
                pre = root;
            }
            help(root.right);
        }
    }
}

