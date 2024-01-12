package LeetCode.month01.day12.demo6;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/12 13:22
 */
public class demo6 {
    public ListNode removeNodes(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            int val = p.val;
            while (!stack.isEmpty() && stack.peek().val < val) {
                stack.pop();
            }
            stack.push(p);
            p = p.next;
        }
        ListNode res = new ListNode();
        while (!stack.isEmpty()){
            ListNode next = stack.pop();
            next.next = res.next;
            res.next = next;
        }
        return res.next;
    }
}

