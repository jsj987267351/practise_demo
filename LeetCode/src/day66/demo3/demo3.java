package day66.demo3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 * @date 2023/6/19 15:53
 */
public class demo3 {
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        if (root.left == null && root.right == null) {
            return res;
        }
//        层序遍历,每次将结果更新为该层的第一个值即可
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }
}

