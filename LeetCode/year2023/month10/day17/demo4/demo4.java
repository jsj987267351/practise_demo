package month10.day17.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/17 12:38
 */
public class demo4 {
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left){
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}

