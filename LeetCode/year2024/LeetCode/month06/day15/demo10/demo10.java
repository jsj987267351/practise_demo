package LeetCode.month06.day15.demo10;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/15 15:23
 */
public class demo10 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        ListNode res = new ListNode();
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || sum > 0) {
            sum += stack1.isEmpty() ? 0 : stack1.poll();
            sum += stack2.isEmpty() ? 0 : stack2.poll();
            ListNode next = new ListNode(sum % 10);
            next.next = res.next;
            res.next = next;
            sum /= 10;
        }
        return res.next;
    }
}

