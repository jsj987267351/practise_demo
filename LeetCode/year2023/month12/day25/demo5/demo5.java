package month12.day25.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/25 14:31
 */
public class demo5 {
    TreeNode pre;
    TreeNode head = new TreeNode(-1);
    public TreeNode convertBiNode(TreeNode root) {
        help(root);
        return head.right;
    }

    public void help(TreeNode root) {
        if (root != null) {
            help(root.left);
            if (pre == null) {
                pre = root;
                head.right = pre;
            } else {
                pre.right = root;
                pre = pre.right;
            }
            pre.left = null;
            help(root.right);
        }
    }
}

