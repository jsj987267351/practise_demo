package day2023_04_02.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @date 2023/4/2 20:26
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class demo2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0;
        int b = 0;
        ListNode A = headA;
        ListNode B = headB;
        while (A != null) {
            a++;
            A = A.next;
        }
        while (B != null) {
            b++;
            B = B.next;
        }
        int length = 0;
        if (a > b) {
            length = a - b;
            for (int i = 0; i < length; i++) {
                headA = headA.next;
            }
        } else {
            length = b - a;
            for (int i = 0; i < length; i++) {
                headB = headB.next;
            }
        }
        while (headA != null&& headB!=null) {
            if (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            } else {
                return headA;
            }
        }
        return null;
    }
}

