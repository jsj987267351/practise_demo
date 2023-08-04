package month08.day04.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/8/4 19:59
 */
public class demo3 {
    public ListNode partition(ListNode head, int x) {
//        创建两个链表，一个链表存储小于x的，一个大于
//        两个链表的移动节点
        ListNode small = new ListNode();
        ListNode large = new ListNode();
        ListNode smallHead = small;
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
//        此时的small与large都在其各自的链表的最后一个节点，因为大的在最后，所以让大的下一指针指向空，防止出现环
//        小的不用置空是因为下面就给小的链表尾部重新赋值了
        large.next = null;
//        让小链表的链表尾部指向大的头部，组成结果链表
        small.next = largeHead.next;
        return smallHead.next;
    }
}

