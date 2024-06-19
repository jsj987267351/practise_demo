package LeetCode.month06.day19.demo10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/19 11:47
 */
public class demo {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode();
        ListNode small = res;
        ListNode next = new ListNode();
        ListNode big = next;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        ListNode next1 = next.next;
        small.next = next1;
        return res.next;
    }
}

