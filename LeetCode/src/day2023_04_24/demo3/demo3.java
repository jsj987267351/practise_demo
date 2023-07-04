package day2023_04_24.demo3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * @date 2023/4/24 14:30
 */
public class demo3 {
    public int minDepth(TreeNode root) {
        if (root ==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i = 0; i <size ; i++) {
                TreeNode poll = queue.poll();
                if (poll.left ==null && poll.right ==null){
                    return depth;
                }
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
        }

        return depth;
    }
}

