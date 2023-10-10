package month10.day10.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/10 13:35
 */
public class demo3 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode last = res;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                int val = head.val;
                while (head != null && head.val == val) {
                    head = head.next;
                }
                last.next = head;
            }else {
                last = last.next;
                head = head.next;
            }
        }
        return res.next;
    }
}

