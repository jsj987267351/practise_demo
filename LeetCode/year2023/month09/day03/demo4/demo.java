package month09.day03.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/legal-binary-search-tree-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/3 12:34
 */
public class demo {
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        boolean right = isValidBST(root.right);
        return right;
    }


    public boolean isValidBST1(TreeNode root) {
        return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean help(TreeNode root, long left, long right) {
        if (root == null) return true;
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return help(root.left, left, root.val) && help(root.right, root.val, right);
    }
}

