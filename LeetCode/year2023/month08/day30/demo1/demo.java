package month08.day30.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * https://leetcode.cn/problems/sum-lists-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/8/30 13:38
 */
public class demo {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int yu = 0;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + yu;
            ListNode next = new ListNode(num % 10);
            yu = num / 10;
            p.next = next;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
//            如果l1没有遍历完的话，因为不确定是否有余数，所以分情况讨论
            if (yu == 0) {
                p.next = l1;
            } else {
                while (l1 != null) {
                    int num = l1.val + yu;
                    ListNode next = new ListNode(num % 10);
                    yu = num / 10;
                    p.next = next;
                    p = p.next;
                    l1 = l1.next;
                }
            }
        } else if (l2 != null) {
            if (yu == 0) {
                p.next = l2;
            } else {
                while (l2 != null) {
                    int num = l2.val + yu;
                    ListNode next = new ListNode(num % 10);
                    yu = num / 10;
                    p.next = next;
                    p = p.next;
                    l2 = l2.next;
                }
            }
        }

        if (yu != 0) {
            p.next = new ListNode(1);
        }
        return res.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//          和上个解答一样，只不过将条件封装在了一个while条件里
        int yu = 0;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (l1 != null || l2 != null || yu != 0) {
            int num = yu;
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            p.next  = new ListNode(num % 10);
            p = p.next;
            yu = num / 10;
        }
        return res.next;
    }
}

