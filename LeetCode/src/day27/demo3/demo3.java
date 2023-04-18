package day27.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @date 2023/4/18 13:37
 */
public class demo3 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (l1!=null && l2 !=null){
            if (l1.val < l2.val){
                result.next = l1;
                result = l1;
                l1 = l1.next;
            }else {
                result.next = l2;
                result = l2;
                l2 = l2.next;
            }
        }
        if (l1 ==null){
            result.next = l2;
        }
        if (l2 == null){
            result.next = l1;
        }

        return temp.next;
    }
}

