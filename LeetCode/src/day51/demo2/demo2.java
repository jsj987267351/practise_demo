package day51.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * @date 2023/5/25 14:41
 */
public class demo2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeD(lists, 0, lists.length - 1);
    }

    public ListNode mergeD(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int m = left + right >>> 1;
        return merge(mergeD(lists, left, m), mergeD(lists, m + 1, right));
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode result = new ListNode(-1, null);
        ListNode temp = result;
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
        } else {
            temp.next = a;
        }
        return result.next;
    }
}

