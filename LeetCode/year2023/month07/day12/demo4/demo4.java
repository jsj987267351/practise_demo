package month07.day12.demo4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 * @date 2023/7/12 15:49
 */
public class demo4 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        就是收集的时候倒序即可,然后最终收集结果的使用 LinkedList 直接调函数
        LinkedList<List<Integer>> result  = new LinkedList<>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode poll = queue.poll();
                list.add(poll.val);

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.addFirst(list);
        }

        return result;
    }
}

