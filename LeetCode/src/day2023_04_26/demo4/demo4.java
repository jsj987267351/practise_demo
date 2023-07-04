package day2023_04_26.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @date 2023/4/26 18:16
 */
public class demo4 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sen = new ListNode(0,head);
        ListNode p = sen;
        ListNode q = sen;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        while (q!=null){
            q = q.next;
            if (q ==null){
                break;
            }
            p =p.next;
        }
        p.next = p.next.next;
        return sen.next;
    }


}

