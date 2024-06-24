package LeetCode.month06.day24.demo10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/24 13:42
 */
public class demo {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) return false;
//        if (t1.val == t2.val && check(t1,t2)) return true;
        return check(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null || t1.val != t2.val) return false;
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }
}

