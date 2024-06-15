package LeetCode.month06.day15.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/15 14:30
 */
public class demo4 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l1 = mergeLists(lists, left, mid);
        ListNode l2 = mergeLists(lists, mid + 1, right);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode p = l1, q = l2, pre = res;
        while (p != null && q != null) {
            if (p.val < q.val) {
                pre.next = p;
                p = p.next;
            } else {
                pre.next = q;
                q = q.next;
            }
            pre = pre.next;
        }
        if (p != null) {
            pre.next = p;
        }
        if (q != null) {
            pre.next = q;
        }
        return res.next;
    }
}

