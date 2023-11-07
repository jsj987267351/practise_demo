package month11.day07.demo6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/7 12:42
 */
public class demo6 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
//        这里找中间节点时，如果fast和slow都从head开始寻找，如果只有两个节点的话就会陷入死循环，要确保在节点数量为偶数时，slow节点会停留在中间两个节点的前一个上面
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(next);

        ListNode res = new ListNode();
        ListNode cur = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left == null) cur.next = right;
        if (right == null) cur.next = left;
        return res.next;
    }


    public ListNode sortList1(ListNode head) {
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        list.sort((a, b) -> a - b);
        ListNode res = new ListNode();
        ListNode cur = res;
        for (int i = 0; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return res.next;
    }
}

