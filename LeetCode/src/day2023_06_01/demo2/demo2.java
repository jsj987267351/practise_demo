package day2023_06_01.demo2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 * @date 2023/6/1 19:44
 */
public class demo2 {
    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }
        Node result = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node pre = null;
        Node later = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) {
//                    当前层第一个节点
                    pre = queue.poll();
                    if (pre.left != null) {
                        queue.offer(pre.left);
                    }
                    if (pre.right != null) {
                        queue.offer(pre.right);
                    }
                } else {
                    later = queue.poll();
                    if (later.left != null) {
                        queue.offer(later.left);
                    }
                    if (later.right != null) {
                        queue.offer(later.right);
                    }
                    pre.next = later;
                    pre = later;
                }
            }
            if (later != null) later.next = null;
        }
        return result;
    }

    public Node connect(Node root) {
//        每个 node 左子树的 next , 就是 node 的右子树
//        每个 node 右子树的 next, 就是 node next 的 左子树
        help(root, null);
        return root;
    }

    private void help(Node root, Node next) {
        if (root != null) {
            root.next = next;
            help(root.left, root.right);
            help(root.right, root.next != null ? root.next.left : null);
        }
    }
}

