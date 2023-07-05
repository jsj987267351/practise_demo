package month07.day05.demo6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/5 14:58
 */
public class demo6 {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        while (l1 != null) {
            queue1.offer(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            queue2.offer(l2.val);
            l2 = l2.next;
        }

        ListNode head = new ListNode();
        ListNode help = head;
        int temp = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty() || temp > 0) {
            int sum = temp;
            sum += queue1.isEmpty() ? 0 : queue1.poll();
            sum += queue2.isEmpty() ? 0 : queue2.poll();
            ListNode node = new ListNode(sum % 10);
            help.next = node;
            help = node;
            temp = sum / 10;
        }
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode help = head;
        int temp = 0;
//        不使用队列，直接遍历
        while (l1 != null || l2 != null || temp > 0) {
            int sum = temp;
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
            ListNode node = new ListNode(sum % 10);
            help.next = node;
            help = node;
            temp = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head.next;
    }
}

