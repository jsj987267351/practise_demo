package month12.day03.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/3 14:08
 */
public class demo2 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            if (help(t1, t2)) {
                return true;
            }
        }
        return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean help(TreeNode t1, TreeNode t2) {
//        要完全砍掉，不能只砍头和尾
        if (t2 == null && t1 == null) {
            return true;
        }
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        return help(t1.left, t2.left) && help(t1.right, t2.right);
    }
}

