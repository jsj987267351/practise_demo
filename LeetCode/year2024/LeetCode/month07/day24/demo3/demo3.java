package LeetCode.month07.day24.demo3;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/24 9:45
 */
public class demo3 {
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            ArrayDeque<TreeNode> newQueue = new ArrayDeque<>();
            int sum = 0;
            for (TreeNode treeNode : queue) {
                if (treeNode.left != null) {
                    sum += treeNode.left.val;
                    newQueue.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    sum += treeNode.right.val;
                    newQueue.addLast(treeNode.right);
                }
            }
            for (TreeNode treeNode : queue) {
                int childSum = (treeNode.left != null ? treeNode.left.val : 0) + (treeNode.right != null ? treeNode.right.val : 0);
                if (treeNode.left != null) treeNode.left.val = sum - childSum;
                if (treeNode.right != null) treeNode.right.val = sum - childSum;
            }
            queue = newQueue;
        }
        return root;
    }
}

