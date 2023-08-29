package month08.day29.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。
 * <p>
 * 假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。
 * <p>
 * 例如，传入节点 c（位于单向链表 a->b->c->d->e->f 中），将其删除后，剩余链表为 a->b->d->e->f
 * https://leetcode.cn/problems/delete-middle-node-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/8/29 16:47
 */
public class demo {
    public void deleteNode(ListNode node) {
//        这里的node就是要删除的节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

