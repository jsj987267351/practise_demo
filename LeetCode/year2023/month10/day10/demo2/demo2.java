package month10.day10.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/10 13:28
 */
public class demo2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }


    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) >> 1;
        ListNode listLeft = merge(lists, left, mid);
        ListNode listRight = merge(lists, mid + 1, right);
        return helpMerge(listLeft, listRight);
    }

    public ListNode helpMerge(ListNode left, ListNode right) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if (left != null) {
            head.next = left;
        }
        if (right != null) {
            head.next = right;
        }
        return res.next;
    }
}

