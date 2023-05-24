package day50.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @date 2023/5/24 16:21
 */
public class demo1 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        获得两个节点的长度
        int suma = 0;
        int sumb = 0;
        ListNode a = headA;
        ListNode b = headB;
        int sum;
        while (a != null) {
            a = a.next;
            suma++;
        }
        while (b != null) {
            b = b.next;
            sumb++;
        }
        if (suma >sumb){
            sum = suma-sumb;
            while (sum>0){
                headA = headA.next;
                sum--;
            }
        }else {
            sum = sumb - suma;
            while (sum>0){
                headB = headB.next;
                sum--;
            }
        }
        while (headA!=null && headB!=null){
            if (headA==headB){
                return headA;
            }else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;

    }
}

