package month07.day31.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/reorder-list/
 * @date 2023/7/31 13:37
 */
public class demo1 {
    public void reorderList1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int left = 0, right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

    public void reorderList2(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = null;
        if (head == null) return;
        ListNode fast = head;
        ListNode slow = head;
//        找到中间节点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;

//        将后半段链表反转
        ListNode next = mid.next;
        mid.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = mid.next;
            mid.next = next;
            next = temp;
        }
        l2 = mid.next;
        mid.next = null;
//      将反转后的后半段与前半段融合
        ListNode l1temp = null;
        ListNode l2temp = null;
        while (l1 != null && l2 != null) {
            l1temp = l1.next;
            l2temp = l2.next;

            l1.next = l2;
            l1 = l1temp;

            l2.next = l1;
            l2 = l2temp;
        }
    }
}

