package month03.day23.demo5;


/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode() {}
 * *     ListNode(int val) { this.val = val; }
 * *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * * }
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class demo {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode resultTemp = new ListNode();
        ListNode resultList = new ListNode();
        resultTemp = resultList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                resultTemp.next = list1;
                list1 = list1.next;
            } else {
                resultTemp.next = list2;
                list2 = list2.next;
            }
            resultTemp = resultTemp.next;
        }
        if (list1 == null) {
            resultTemp.next = list2;
        }
        if (list2 == null) {
            resultTemp.next = list1;
        }
        return resultList.next;
    }
}
