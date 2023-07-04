package day2023_04_10.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/4/10 17:10
 */
public class demo4 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode a = new ListNode(-1);
        a.next = head;
        while (a.next != null) {
            if (a.next.val == val && a.next.next != null) {
                a.next = a.next.next;
                break;
            }
            if (a.next.val == val && a.next.next == null) {
                a.next = null;
                break;
            }
            a = a.next;
        }
        return head;
    }
}

