package LeetCode.month06.day12.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/12 13:06
 */
public class demo1 {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode res = new ListNode();
            ListNode p = head, pre = res, begin = head;
            int index = 1;
            while (p != null) {
                if (index % k == 0) {
                    ListNode next = p.next;
                    p.next = null;
                    ListNode reverse = reverse(begin);
                    pre.next = reverse;
                    while (pre.next != null) {
                        pre = pre.next;
                    }
                    begin = next;
                    p = next;
                }else {
                    p = p.next;
                }
                index++;
            }
            pre.next = begin;
            return res.next;
        }

        public ListNode reverse(ListNode head) {
            ListNode res = new ListNode();
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

