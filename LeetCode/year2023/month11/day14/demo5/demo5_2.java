package month11.day14.demo5;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/14 16:00
 */
public class demo5_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stackL1 = new LinkedList<>();
        LinkedList<Integer> stackL2 = new LinkedList<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stackL1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stackL2.push(l2.val);
                l2 = l2.next;
            }
        }
        int temp = 0;
        ListNode res = new ListNode();

        while (!stackL1.isEmpty() || !stackL2.isEmpty() || temp > 0) {
            temp += stackL1.isEmpty() ? 0 : stackL1.poll();
            temp += stackL2.isEmpty() ? 0 : stackL2.poll();
            ListNode newNode = new ListNode(temp % 10);
            newNode.next = res.next;
            res.next = newNode;
            temp = temp / 10;
        }
        return res.next;
    }
}

