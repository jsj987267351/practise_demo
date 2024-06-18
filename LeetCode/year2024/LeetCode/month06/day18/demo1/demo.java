package LeetCode.month06.day18.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/18 9:51
 */
public class demo {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return help(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean help(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        if (A.val != B.val) return false;
        return help(A.left, B.left) && help(A.right, B.right);
    }
}

