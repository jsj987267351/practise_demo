package month12.day07.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/7 14:10
 */
public class demo4 {
    public boolean isPalindrome(ListNode head) {
        ListNode newListNode = new ListNode(-1);
        newListNode.next = head;
        ListNode fast = head, slow = newListNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reverse = reverse(slow.next);
        slow.next = null;
        while (head != null && reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode res = new ListNode(-1);
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

