package day34.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/delete-node-in-a-linked-list/
 * @date 2023/5/5 21:23
 */
public class demo4 {
    public void deleteNode1(ListNode node) {
        ListNode temp = node;

        node.val = node.next.val;
        node = node.next;

        while (node.next!=null){
            node.val = node.next.val;
            node = node.next;
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

