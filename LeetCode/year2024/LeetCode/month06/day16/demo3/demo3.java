package LeetCode.month06.day16.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/16 14:08
 */
public class demo3 {
    public void flatten(TreeNode root) {
        TreeNode p = root;
        while (p != null) {
            if (p.left != null) {
                TreeNode left = p.left;
                p.left = null;
                TreeNode right = p.right;
                p.right = left;
                TreeNode temp = left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = right;
            }
            p = p.right;
        }
    }
}

