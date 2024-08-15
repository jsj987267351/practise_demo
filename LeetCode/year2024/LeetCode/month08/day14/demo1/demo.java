package LeetCode.month08.day14.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/14 9:48
 */
public class demo {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root.val < p.val && root.val < q.val || root.val > p.val && root.val > q.val) {
            if (root.val < p.val){
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return root;
    }
}

