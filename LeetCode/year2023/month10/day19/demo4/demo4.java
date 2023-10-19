package month10.day19.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/19 12:51
 */
public class demo4 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}

