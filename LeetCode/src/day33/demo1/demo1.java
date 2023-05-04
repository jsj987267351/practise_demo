package day33.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * https://leetcode.cn/problems/balanced-binary-tree/
 * @date 2023/5/4 14:59
 */
public class demo1 {
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(getDepth(root.left)-getDepth(root.right)) <2 && isBalanced1(root.right) &&isBalanced1(root.left);
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getDepth(root.right),getDepth(root.left)) +1 ;
        }
    }



    public boolean isBalanced(TreeNode root) {
        return recur(root)!=-1;
    }

    public int recur(TreeNode root){
        if (root==null)  return 0;
        int left = recur(root.left);
        if (left == -1)  return -1;
        int right = recur(root.right);
        if (right ==-1)  return -1;
        return Math.abs(left-right) <2?Math.max(left,right)+1:-1;
    }
}

