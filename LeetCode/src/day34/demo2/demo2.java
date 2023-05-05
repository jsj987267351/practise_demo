package day34.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/
 * @date 2023/5/5 20:16
 */
public class demo2 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        reverse(root);
        return root;
    }

    public void reverse(TreeNode root) {
        if (root ==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        reverse(root.left);
        reverse(root.right);
    }
}

