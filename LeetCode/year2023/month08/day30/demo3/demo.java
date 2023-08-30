package month08.day30.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * @date 2023/8/30 14:18
 */
public class demo {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1 = 0, length2 = 0;
        ListNode p = headA, q = headB;
        while (p != null || q != null) {
            if (p != null) {
                length1++;
                p = p.next;
            }
            if (q != null) {
                length2++;
                q = q.next;
            }
        }
        int len = Math.abs(length1 - length2);
        if (length1 > length2) {
            while (len > 0) {
                headA = headA.next;
                len--;
            }
        } else {
            while (len > 0) {
                headB = headB.next;
                len--;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}

