package month09.day28.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/28 17:28
 */
public class demo3 {
    TreeNode pre = null;
    TreeNode head = new TreeNode(-1);

    public TreeNode convertBiNode(TreeNode root) {
//          中序遍历
        help(root);
        return head.right;
    }

    public void help(TreeNode root) {
        if (root != null) {
            help(root.left);
            if (pre == null) {
//                第一个节点的话，需要把头节点连接上后在更新前置节点
                head.right = root;
                pre = root;
            } else {
//                如果不是前置节点的话，直接连接上后更新即可
                pre.right = root;
                pre = root;
            }
            root.left = null;
            help(root.right);
        }
    }
}

