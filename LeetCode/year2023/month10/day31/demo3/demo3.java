package month10.day31.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/31 11:37
 */
public class demo3 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0, head);
        ListNode p = res;
        while (p.next != null) {
            if (p.next.val == val) {
                ListNode remove = p.next;
                p.next = remove.next;
            }else {
                p = p.next;
            }
        }
        return res.next;
    }
}

