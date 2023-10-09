package month10.day09.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/?envType=list&envId=hliQiQFH
 * @date 2023/10/9 12:06
 */
public class demo3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findRoot(root, p, q);
    }

    public TreeNode findRoot(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = findRoot(root.left, p, q);
        TreeNode right = findRoot(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
}

