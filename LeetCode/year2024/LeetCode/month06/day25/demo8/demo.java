package LeetCode.month06.day25.demo8;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/25 11:12
 */
public class demo {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        next = reverse(next);
        while (head != null && next != null) {
            if (head.val != next.val) return false;
            head = head.next;
            next = next.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode res = new ListNode(0);
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

