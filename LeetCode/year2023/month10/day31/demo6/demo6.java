package month10.day31.demo6;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/31 11:53
 */
public class demo6 {
    public boolean hasCycle(ListNode head) {
        if (head== null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!= null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}

