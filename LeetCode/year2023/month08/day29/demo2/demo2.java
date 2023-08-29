package month08.day29.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/8/29 16:45
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 */
public class demo2 {
    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast!= null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}

