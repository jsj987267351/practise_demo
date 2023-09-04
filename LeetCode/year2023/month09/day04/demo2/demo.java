package month09.day04.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/first-common-ancestor-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/4 13:10
 */
public class demo {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
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

