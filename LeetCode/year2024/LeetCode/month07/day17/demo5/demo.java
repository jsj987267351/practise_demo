package LeetCode.month07.day17.demo5;

import java.util.logging.Level;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/17 10:17
 */
public class demo {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        help(root.left, root.right, 1);
        return root;
    }

    public void help(TreeNode left, TreeNode right, int index) {
        if (left == null) return;
        if (index % 2 != 0) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        help(left.left, right.right, index + 1);
        help(left.right, right.left, index + 1);
    }
}

