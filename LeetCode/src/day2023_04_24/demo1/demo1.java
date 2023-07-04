package day2023_04_24.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * @date 2023/4/24 14:22
 */
public class demo1 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Integer.max(left,right) + 1;
    }
}

