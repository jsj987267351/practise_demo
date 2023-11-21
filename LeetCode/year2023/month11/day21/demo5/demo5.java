package month11.day21.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/21 15:34
 */
public class demo5 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null){
            return false;
        }
        return help(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean help(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return help(A.left, B.left) && help(A.right, B.right);
    }
}

