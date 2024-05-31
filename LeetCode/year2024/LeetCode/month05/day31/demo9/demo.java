package LeetCode.month05.day31.demo9;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 13:37
 */
public class demo {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode p = sentinel;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                int value = head.val;
                while (head != null && head.val == value) {
                    head = head.next;
                }
                p.next = head;
            } else {
                p = p.next;
                head = head.next;
            }
        }
        return sentinel.next;
    }
}

