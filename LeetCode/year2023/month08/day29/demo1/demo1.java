package month08.day29.demo1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * https://leetcode.cn/problems/remove-duplicate-node-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/8/29 16:33
 */
public class demo1 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode p = head;
        while (p.next != null) {
            ListNode cur = p.next;
            if (set.contains(cur.val)) {
                p.next = cur.next;
            } else {
                set.add(cur.val);
                p = p.next;
            }
        }
        return head;
    }
}

