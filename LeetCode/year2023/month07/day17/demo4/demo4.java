package month07.day17.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @date 2023/7/17 18:23
 */
public class demo4 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return help(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean help(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return help(A.left, B.left) && help(A.right, B.right);
    }
}

