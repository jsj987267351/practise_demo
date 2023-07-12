package month07.day12.demo5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
 * @date 2023/7/12 15:55
 */
public class demo5 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root ==null){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll.val);
                List<Node> children = poll.children;
                for (Node child : children) {
                    queue.offer(child);
                }
            }
            res.add(list);
        }
        return res;
    }
}

