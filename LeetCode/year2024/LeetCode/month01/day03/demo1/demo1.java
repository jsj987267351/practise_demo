package LeetCode.month01.day03.demo1;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/3 13:14
 */
public class demo1 {
    public ListNode removeNodes(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            while (!stack.isEmpty() && p.val > stack.peek().val) {
                stack.pop();
            }
            stack.push(p);
            p = p.next;
        }
        ListNode res = new ListNode();
        while (!stack.isEmpty()) {
            ListNode next = stack.pop();
            next.next = res.next;
            res.next = next;
        }
        return res.next;
    }
}

