package day08.demo1;

/***
 * @description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @return
 * @author 大爆炸
 * @date 2023/3/24 19:54
 */

public class demo {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

}
