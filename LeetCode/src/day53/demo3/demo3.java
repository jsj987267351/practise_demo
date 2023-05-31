package day53.demo3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * https://leetcode.cn/problems/binary-tree-right-side-view/
 * @date 2023/5/31 15:37
 */
public class demo3 {
    public List<Integer> rightSideView(TreeNode root) {
//        思路：使用层序遍历，将每一层的最后一个节点的值加入结果
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
//        队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
//        用来记录每层的最后一个节点
        TreeNode poll = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            list.add(poll.val);
        }
        return list;
    }
}

