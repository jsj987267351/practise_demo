package month09.day04.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/check-subtree-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/4 13:16
 */
public class demo {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) return false;
        if (t1.val == t2.val) {
//            只有符合才能return true
            if (help(t1, t2)) {
                return true;
            }
        }
        boolean left = checkSubTree(t1.left, t2);
        boolean right = checkSubTree(t1.right, t2);
        return left || right;
    }

    public boolean help(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        boolean left = help(t1.left, t2.left);
        boolean right = help(t1.right, t2.right);
        return left && right;
    }

}

