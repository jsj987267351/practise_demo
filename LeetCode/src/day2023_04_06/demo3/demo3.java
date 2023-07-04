package day2023_04_06.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @date 2023/4/6 11:15
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class demo3 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int length = 1;
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        head = head.next;
        while (head != null) {
            ListNode temp = head.next;
            head.next = sentinel.next;
            sentinel.next = head;
            head = temp;
            length++;
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = sentinel.next.val;
            sentinel = sentinel.next;
        }
        return result;
    }
}

