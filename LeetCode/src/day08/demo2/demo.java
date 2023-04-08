package day08.demo2;


/***
 * @description 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * @return
 * @author 大爆炸
 * @date 2023/3/24 19:55
 */
public class demo {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
                if (head == null) {
                    break;
                }
            }
        }
        return result;
    }
}
