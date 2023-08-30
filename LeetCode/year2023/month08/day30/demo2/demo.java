package month08.day30.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 编写一个函数，检查输入的链表是否是回文的。
 * https://leetcode.cn/problems/palindrome-linked-list-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/8/30 14:02
 */
public class demo {
    public boolean isPalindrome(ListNode head) {
//         找到中间节点然后把后半部分翻转，然后从头开始判断
        ListNode middle = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            middle = middle.next;
        }
//        此时的middle如果链表数量是偶数的话为中间两个节点的右半部分，奇数为中间节点
//        没有记录前置节点，所以创建新节点进行翻转
        ListNode tmp = null;
        while (middle != null) {
            ListNode next = middle.next;
            middle.next = tmp;
            tmp = middle;
            middle = next;
        }

//       前面并没有断开，所有如果奇数的话两个链表都连上了中间那个节点
        while (tmp != null) {
            if (head.val != tmp.val) {
                return false;
            }
            tmp = tmp.next;
            head = head.next;
        }
        return true;
    }
}

