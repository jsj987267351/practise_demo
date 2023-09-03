package month09.day03.demo2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * https://leetcode.cn/problems/list-of-depth-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/3 12:20
 */
public class demo {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        ListNode head = null;
        ListNode p = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    head = new ListNode(poll.val);
                    p = head;
                } else {
                    p.next = new ListNode(poll.val);
                    p = p.next;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            p.next = null;
            list.add(head);
        }
        ListNode[] res = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

