package month09.day03.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/check-balance-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/3 12:28
 */
public class demo {
    public boolean isBalanced(TreeNode root) {
        return help(root) != -1;
    }

    public int help(TreeNode root) {
        if (root == null) return 0;
        int left = help(root.left);
        if (left == -1) return -1;
        int right = help(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) < 2) {
            return Math.max(left, right) + 1;
        }
        return -1;
    }
}

