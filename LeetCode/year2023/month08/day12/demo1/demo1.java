package month08.day12.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 * @date 2023/8/12 18:08
 */
public class demo1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return help(lists, 0, lists.length - 1);
    }


    public ListNode help(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode liftMerge = help(lists, left, mid);
        ListNode rightMerge = help(lists, mid + 1, right);
        return mergeTwo(liftMerge, rightMerge);
    }

    public ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode res = new ListNode();
        ListNode temp = res;
        while (a != null && b != null) {
            if (a.val < b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        if (a == null) {
            temp.next = b;
        }
        if (b == null) {
            temp.next = a;
        }
        return res.next;
    }
}

