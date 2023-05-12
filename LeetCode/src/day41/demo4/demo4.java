package day41.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list-ii
 * @date 2023/5/12 13:40
 */
public class demo4 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

//        要删除节点的前节点
        ListNode pre = new ListNode(0,head);
        int l = 1 ,r = 1;
        ListNode p = head,q = head;

//        找到left所在节点
        while (l!= left) {
            pre = pre.next;
            p = p.next;
            l++;
        }

//        找到right所在节点
        while (r!= right) {
            q = q.next;
            r++;
        }

//        将链表断开
        ListNode qt = q.next;
        q.next = null;

//        最后拼接用的尾节点
        ListNode pt = p;

//        头插法进行反转
        while (p != null) {
            ListNode temp = p.next;
            p.next = pre.next;
            pre.next = p;
            p = temp;
        }

        pt.next = qt;

        if (left==1){
            return pre.next;
        }
        return head;
    }
}

