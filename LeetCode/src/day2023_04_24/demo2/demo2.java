package day2023_04_24.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * https://leetcode.cn/problems/symmetric-tree/
 * @date 2023/4/24 14:25
 */
public class demo2 {
    public boolean isSymmetric(TreeNode root) {
        return duichen(root.left,root.right);
    }

    public boolean duichen(TreeNode left , TreeNode right){
        if (left ==null && right ==null){
            return true;
        }
        if (left== null || right ==null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return duichen(left.left,right.right)&& duichen(left.right,right.left);
    }
}

