package day16.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * @date 2023/4/4 12:31
 */
public class demo {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p2 = p2.next;
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }
}

