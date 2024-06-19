package LeetCode.month06.day19.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/19 10:49
 */
public class demo {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return left;
        int right = getDepth(root.right);
        if (right == -1) return right;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}

