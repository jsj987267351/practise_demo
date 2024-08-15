package LeetCode.month08.day14.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/14 11:01
 */
public class demo {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode p = res;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                int value = head.val;
                while (head != null && head.val == value) {
                    head = head.next;
                }
                p.next = head;
//                这里不让p往后走一步是因为有可能当前head还是重复值
            }else {
                head = head.next;
                p = p.next;
            }
        }
        return res.next;
    }
}

