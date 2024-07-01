package LeetCode.month07.day01.demo10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/1 10:39
 */
public class demo {
    public void reorderList(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode reversed = reverseList(next);
        while (reversed != null) {
            ListNode next1 = reversed.next;
            reversed.next = head.next;
            head.next = reversed;
            head = reversed.next;
            reversed = next1;
        }
    }

    public ListNode reverseList(ListNode head) {
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

