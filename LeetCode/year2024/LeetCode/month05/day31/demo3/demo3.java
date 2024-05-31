package LeetCode.month05.day31.demo3;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 11:45
 */
public class demo3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root.val < p.val && root.val < q.val || root.val > p.val && root.val > q.val) {
            if (root.val < p.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }
}

