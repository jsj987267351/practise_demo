package month11.day14.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/14 15:51
 */
public class demo5 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverse(l1);
        ListNode reverseL2 = reverse(l2);
        ListNode res = new ListNode();
        ListNode a = res;
        ListNode p = reverseL1;
        ListNode q = reverseL2;
        int temp = 0;
        while (p != null || q != null) {
            if (p != null) {
                temp += p.val;
                p = p.next;
            }
            if (q != null) {
                temp += q.val;
                q = q.next;
            }
            a.next = new ListNode(temp % 10);
            temp = temp / 10;
            a = a.next;
        }
        if (temp != 0) {
            a.next = new ListNode(1);
        }
        return reverse(res.next);
    }

    public ListNode reverse(ListNode l) {
        ListNode p = l;
        ListNode res = new ListNode();
        while (p != null) {
            ListNode next = p.next;
            p.next = res.next;
            res.next = p;
            p = next;
        }
        return res.next;
    }
}

