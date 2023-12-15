package month12.day15.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/15 14:35
 */
public class demo {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;
        help(root.left, root.right, 1);
        return root;
    }

    public void help(TreeNode left, TreeNode right, int cur) {
        if (left == null) return;
        if (cur % 2 != 0) {
            int val = left.val;
            left.val = right.val;
            right.val = val;
        }
//        不是两两反转，而是整体一行都反转，所以从该行两头向中间不断交换值即可
        help(left.left, right.right, cur + 1);
        help(left.right, right.left, cur + 1);
    }
}

