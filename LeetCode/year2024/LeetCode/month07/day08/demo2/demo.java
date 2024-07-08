package LeetCode.month07.day08.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/8 9:29
 */
public class demo {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        if (p.right != null) {
            res = p.right;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                res = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return res;
    }
}

