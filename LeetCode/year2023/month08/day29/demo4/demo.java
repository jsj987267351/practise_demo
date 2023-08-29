package month08.day29.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * https://leetcode.cn/problems/partition-list-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/8/29 16:51
 */
public class demo {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode res = small;
        ListNode big = new ListNode(1);
        ListNode last = big;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = last.next;
        return res.next;
    }
}

