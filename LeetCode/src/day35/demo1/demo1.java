package day35.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 * @date 2023/5/6 15:28
 */
public class demo1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return fn(root.left, root.right);
    }

    public boolean fn(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return fn(left.left,right.right) &&fn(left.right,right.left);
    }
}

