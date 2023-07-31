package month07.day31;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/31 14:27
 */
public class demo {
    public void reorderList(ListNode head) {
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

