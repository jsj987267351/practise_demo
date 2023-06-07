package day59.demo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&envId=top-100-liked
 * @date 2023/6/7 15:59
 */
public class demo2 {
    public ListNode sortList1(ListNode head) {
//       暴力解法，将链表所有值都存起来然后排序，最后挨个取出连接即可
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        list.sort(((o1, o2) -> o1 - o2));
        ListNode result = new ListNode();
        ListNode cur = result;
        int index = 0;
        while (index < list.size()) {
            cur.next = new ListNode(list.get(index));
            cur = cur.next;
            index++;
        }
        return result.next;
    }

    public ListNode sortList(ListNode head) {
//        使用递归归并排序
//        递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
//        将链表切成两份，奇数则从中间切，偶数则从中间的左边切
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
//        将切断的右半边节点存储起来
        ListNode temp = slow.next;
//        切断
        slow.next = null;
//        递归调用，得到左右两边节点
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

//        将两边节点排序即可
        ListNode result = new ListNode();
        ListNode p = result;
        while (left!=null && right!=null){
            if (left.val<right.val){
                p.next = left;
                left = left.next;
            }else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if (left==null) p.next = right;
        if (right==null) p.next = left;
        return result.next;
    }
}

