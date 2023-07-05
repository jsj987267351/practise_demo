package month03.day24.demo1;

/***
 * @description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @return
 * @author 大爆炸
 * @date 2023/3/24 19:54
 * https://leetcode.cn/problems/reverse-linked-list/
 */

public class demo {
    public ListNode reverseList1(ListNode head) {
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

    public ListNode reverseList(ListNode head) {
        if (head ==null){
            return null;
        }
        ListNode sen = new ListNode(0,head);
        ListNode temp = head.next;
        head.next = null;
        head = temp;

        while (head != null) {
            temp = head.next;
            head.next = sen.next;
            sen.next = head;
            head = temp;
        }
        return sen.next;
    }
}
