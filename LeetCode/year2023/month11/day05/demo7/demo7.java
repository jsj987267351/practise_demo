package month11.day05.demo7;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/5 18:17
 */
public class demo7 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode();
        ListNode cur = res, start = head, p = head;
        int num = 1;
        while (p != null) {
            if (num == k){
                ListNode next = p.next;
                p.next = null;
                ListNode reverse = reverse(start);
                cur.next = reverse;
                while (cur.next!= null){
                    cur = cur.next;
                }
                p = next;
                start = next;
                num = 1;
            }else {
                num++;
                p = p.next;
            }
        }
        cur.next = start;
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

