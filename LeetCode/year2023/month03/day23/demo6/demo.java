package month03.day23.demo6;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode() {}
 * *     ListNode(int val) { this.val = val; }
 * *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * * }
 * https://leetcode.cn/problems/remove-linked-list-elements/
 */
public class demo {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (true) {
            if (head.val == val) {
                head = head.next;
                if(head==null){
                    return null;
                }
            } else {
                break;
            }
        }
        ListNode result = head;
        for (; head != null; ) {
            ListNode next = head.next;
            if (next == null) {
                return result;
            }
            if (next.val == val) {
                head.next = next.next;
                next.next = null;
            } else {
                head = head.next;
            }
        }
        return result;
    }
}
