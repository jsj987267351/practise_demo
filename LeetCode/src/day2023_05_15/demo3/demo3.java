package day2023_05_15.demo3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * @date 2023/5/15 17:57
 */
public class demo3 {
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode index1 = head;
        ListNode index2 = null;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
//            说明有环
            if (fast == slow){
                index2 = fast;
                while (index1!=index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
//            说明有环
            if (fast == slow){
                slow = head;
                while (slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

}

