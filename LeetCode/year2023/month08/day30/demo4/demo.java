package month08.day30.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * https://leetcode.cn/problems/linked-list-cycle-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/8/30 14:25
 */
public class demo {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head != fast){
                    head = head.next;
                    fast = fast.next;
                }
                return head;
            }
        }
        return null;
    }
}

