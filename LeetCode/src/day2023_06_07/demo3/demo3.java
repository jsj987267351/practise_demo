package day2023_06_07.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
 * @date 2023/6/7 16:31
 */
public class demo3 {
    public ListNode reverseKGroup(ListNode head, int k) {
//        特殊判断
        if (head == null || head.next == null || k == 1) {
            return head;
        }
//        返回的最终节点
        ListNode result = new ListNode();
        ListNode cur = result;
//        需要反转链表的头节点
        ListNode start = head;
//        计数
        int i = 1;
        ListNode p = head;

        while (p != null) {
            if (i == k) {
//                数量到达反转，进行反转
//                临时存储后面的链表
                ListNode next = p.next;
//                将后面的链表切断，然后扔进反转函数进行反转，返回的是反转后的头节点
                p.next = null;
                ListNode reverse = reverse(start);
//                连接
                cur.next = reverse;
//                因为连接的是一个链表，所以要往后移到尾节点
                while (cur.next != null) {
                    cur = cur.next;
                }
//                重新赋值反转链表的头节点
                start = next;
                p = next;
//                重新置为1
                i = 1;
            } else {
                i++;
                p = p.next;
            }
        }
//        剩余的节点不用反转
        cur.next = start;
        return result.next;
    }

//    使用头插法实现反转链表方法
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode();
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = result.next;
            result.next = p;
            p = next;
        }
        return result.next;
    }
}

