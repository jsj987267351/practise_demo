package month04.day24.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * https://leetcode.cn/problems/same-tree/
 * @date 2023/4/24 15:07
 */
public class demo5 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return fn(p, q);
    }

    public boolean fn(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return fn(p.left,q.left) && fn(p.right,q.right);
    }
}

