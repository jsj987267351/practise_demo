package month12.day14.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/14 16:03
 */
public class demo2 {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode reverse = reverse(next);
        fast = head;
        while (fast != null && reverse != null) {
            ListNode next1 = reverse.next;
            reverse.next = fast.next;
            fast.next = reverse;
            fast = reverse.next;
            reverse = next1;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode res = new ListNode();
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = res.next;
            res.next = p;
            p = next;
        }
        return res.next;
    }
}

