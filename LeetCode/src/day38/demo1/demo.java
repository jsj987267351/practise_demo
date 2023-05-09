package day38.demo1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * https://leetcode.cn/problems/diameter-of-binary-tree/
 * @date 2023/5/9 18:08
 */
public class demo {
    int sum = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return sum;

    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        sum = Math.max(sum, left + right);
        return Math.max(left, right) + 1;
    }
}

