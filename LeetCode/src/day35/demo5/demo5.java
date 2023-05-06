package day35.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @date 2023/5/6 17:43
 */
public class demo5 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sen = new ListNode();
        ListNode p = head;
        ListNode q = head.next;

        p.next = q.next;
        q.next = p;
        sen.next = q;

        ListNode temp = p;

        while (p!= null) {

            if (p.next==null || p.next.next==null){
                break;
            }
            p = p.next;
            q = p.next;

            p.next = q.next;
            q.next = p;

            temp.next = q;
            temp = p;

        }

        return sen.next;
    }
}

