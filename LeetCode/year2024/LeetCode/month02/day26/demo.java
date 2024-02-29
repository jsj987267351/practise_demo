package LeetCode.month02.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/26 10:11
 */
public class demo {
    int res;

    public int rangeSumBST(TreeNode root, int low, int high) {
        res = 0;
        help(root, low, high);
        return res;
    }

    public void help(TreeNode root, int low, int high) {
        if (root != null) {
            if (root.val < low) {
                help(root.right, low, high);
            }else if (root.val > high) {
                help(root.left, low, high);
            }else {
                res += root.val;
                help(root.left, low, high);
                help(root.right, low, high);
            }
        }
    }
}

