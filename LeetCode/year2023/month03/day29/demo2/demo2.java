package month03.day29.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @date 2023/3/29 13:40
 * https://leetcode.cn/problems/palindrome-linked-list/
 */

public class demo2 {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        ListNode after = null;
        ListNode after2 = null;
        while (q.next != null) {
            q = q.next;
            if (q.next != null) {
                q = q.next;
            }else {
                break;
            }
            p = p.next;
        }
        after = p.next;
        p.next = null;
        while (after!=null){
           after2 =  after.next;
           after.next = p.next;
           p.next =after;
           after = after2;
        }
        after = p.next;
        while (after!=null){
            if (head.val!= after.val){
                return false;
            }
            head = head.next;
            after = after.next;
        }
        return true;
    }
}

