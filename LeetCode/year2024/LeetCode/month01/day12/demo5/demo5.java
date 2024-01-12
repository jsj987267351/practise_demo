package LeetCode.month01.day12.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/12 13:16
 */
public class demo5 {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        help(root.left, root.right, 1);
        return root;
    }

    public void help(TreeNode left, TreeNode right, int cur) {
        if (left == null) return;
        if (cur % 2 == 1) {
            int val = left.val;
            left.val = right.val;
            right.val = val;
        }
        help(left.left, right.right, cur + 1);
        help(left.right, right.left, cur + 1);
    }
}

