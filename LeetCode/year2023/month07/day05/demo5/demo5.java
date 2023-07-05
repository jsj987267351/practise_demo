package month07.day05.demo5;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/5 14:27
 */
public class demo5 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         每日一题
//        使用linklist比直接用stack效率要高一些
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int temp = 0;
        ListNode head = new ListNode();
//        最后一个判断条件是判断最后一组是否还有进制数
        while (!stack1.isEmpty() || !stack2.isEmpty() || temp > 0) {
            int sum = temp;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode next = new ListNode(sum % 10);
            next.next = head.next;
            head.next = next;
            temp = sum / 10;
        }
        return head.next;
    }
}

