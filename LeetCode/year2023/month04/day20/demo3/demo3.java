package month04.day20.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * @date 2023/4/20 20:53
 */
public class demo3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode p = result;
        int[] int1= new int[100];
        int[] int2 = new int[100];
        int i = 99;
        int j = 99;
        while (l1!=null){
            int1[i] = l1.val;
            l1 = l1.next;
            i--;
        }
        while (l2!=null){
            int2[j] = l2.val;
            l2 = l2.next;
            j--;
        }
        int sum = 0;
        for (int k = 99, h = 99; k >i || h > j; k--,h--) {
             sum += int1[k] + int2[h];
            ListNode listNode = new ListNode(sum % 10);
            p.next = listNode;
            p = listNode;
            sum = sum/10;
        }
        if (sum == 1) {
            ListNode listNode = new ListNode(1);
            p.next  = listNode;
        }
        return result.next;
    }
}

