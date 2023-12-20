package month12.day20.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/20 14:27
 */
public class demo3 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
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

