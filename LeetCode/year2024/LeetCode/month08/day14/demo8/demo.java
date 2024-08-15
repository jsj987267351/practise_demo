package LeetCode.month08.day14.demo8;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/14 11:27
 */
public class demo {
    public boolean isValidBST(TreeNode root) {
        return preOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean preOrder(TreeNode root, long left, long right) {
        if (root == null) return true;
        if (root.val <= left || root.val >= right) {
            return false;
        }
       return preOrder(root.left,left,  root.val) && preOrder(root.right, root.val,right);
    }
}

