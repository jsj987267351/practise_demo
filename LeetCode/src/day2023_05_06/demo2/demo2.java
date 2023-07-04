package day2023_05_06.demo2;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定二叉树的根节点 root ，返回所有左叶子之和。
 * https://leetcode.cn/problems/sum-of-left-leaves/
 * @date 2023/5/6 15:35
 */
public class demo2 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null){
            return 0;
        }
        return fn(root);
    }

    public int fn(TreeNode root) {
        int sum = 0;

        if (root.left!=null){
            if (isyezi(root.left)){
                sum+=root.left.val;
            }else {
                sum+=fn(root.left);
            }
        }

        if (root.right!=null&&!isyezi(root.right)){
            sum+=fn(root.right);
        }

        return sum;
    }

    public boolean isyezi(TreeNode root){
        return root.left==null && root.right==null;
    }
}

