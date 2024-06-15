package LeetCode.month06.day15.demo7;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/15 14:55
 */
public class demo7 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}

