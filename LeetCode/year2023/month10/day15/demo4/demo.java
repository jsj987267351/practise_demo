package month10.day15.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/15 14:07
 */
public class demo {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        k = k % len;
        if (len == 1 || k == 0) {
            return head;
        }
        p = head;
        for (int i = 0; i < len - k - 1; i++) {
            p = p.next;
        }
        ListNode next = p.next;
        p.next = null;
        ListNode res = next;
        while (next.next != null) {
            next = next.next;
        }
        next.next = head;
        return res;
    }
}

