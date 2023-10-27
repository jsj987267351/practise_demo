package month10.day27.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/27 12:32
 */
public class demo5 {

    public boolean isBalanced(TreeNode root) {
        return isGoodTree(root) != -1;
    }

    public int isGoodTree(TreeNode root) {
        if (root == null) return 0;
        int left = isGoodTree(root.left);
        if (left == -1) return -1;
        int right = isGoodTree(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//
//        return Math.abs(getDepth(root.left) - getDepth(root.right)) <2 && isBalanced(root.left) && isBalanced(root.right);
//    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

