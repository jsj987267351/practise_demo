package month12.day06.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/6 13:34
 */
public class demo4 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode r = res;
        ListNode p = l1, q = l2;
        int temp = 0;
        while (p != null || q != null || temp > 0) {
            if (p != null) {
                temp += p.val;
                p = p.next;
            }
            if (q != null) {
                temp += q.val;
                q = q.next;
            }
            ListNode cur = new ListNode(temp % 10);
            r.next = cur;
            r = r.next;
            temp /= 10;
        }
        return res.next;
    }
}

