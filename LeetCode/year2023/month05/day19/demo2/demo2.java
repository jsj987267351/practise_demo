package month05.day19.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/5/19 14:51
 */
public class demo2 {
    public ListNode rotateRight(ListNode head, int k) {
//        判断特殊情况
        if (k == 0 || head == null) {
            return head;
        }
//        计算指针数量
        int sum = 1;
        ListNode num = head;
        while (num.next != null) {
            sum++;
            num = num.next;
        }
//        特殊情况
        if (sum == 1 || k % sum == 0) {
            return head;
        }
//        找到最后k个节点
        ListNode p = head;
        for (int i = 0; i < sum - k % sum - 1; i++) {
            p = p.next;
        }
//        断开节点
        ListNode q = p.next;
        p.next = null;
        p = q;
//        找到第二节点的尾部
        while (p.next != null) {
            p = p.next;
        }
//        拼接
        p.next = head;
        return q;
    }
}



