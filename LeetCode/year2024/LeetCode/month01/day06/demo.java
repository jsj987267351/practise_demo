package LeetCode.month01.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/6 12:54
 */
public class demo {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode p = head;
        while (p.next != null) {
            ListNode next = p.next;
            int cur = help(p.val, next.val);
            ListNode listNode = new ListNode(cur, next);
            p.next = listNode;
            p = next;
        }
        return head;
    }

    public int help(int a, int b) {
        int cur = Math.min(a, b);
        for (int i = cur; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}

