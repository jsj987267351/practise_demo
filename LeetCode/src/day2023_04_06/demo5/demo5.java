package day2023_04_06.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @date 2023/4/6 11:54
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 */
public class demo5 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-1);
        ListNode a = head;
        sentinel.next = head;
        head = head.next;
        while (head != null) {
            ListNode temp = head.next;
            head.next = sentinel.next;
            sentinel.next = head;
            head = temp;
        }
        a.next = null;
        return sentinel.next;
    }
}

