package day59.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/copy-list-with-random-pointer/
 * @date 2023/6/7 15:19
 */
public class demo1 {
    public Node copyRandomList1(Node head) {
//        首先在每个原节点后面创建一个新节点，形成一个新旧交叉链表，这样就不会导致random指针为null
//        然后将每个新节点的random指向原节点的random的next
//        最后分离出来即可
        Node p = head;
        while (p != null) {
//            在每个链表节点后创建一个新节点并连接起来
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
//        为每个新节点的random赋值
        p = head;
        while (p != null) {
//            要判空，因为如果random为null的话，null的next就会抛异常
            if (p.random != null) {
                Node newNode = p.next;
                newNode.random = p.random.next;
            }
            p = p.next.next;
        }
//        将新旧链表分离出来
        Node result = new Node(0);
        Node cur = result;
        p = head;
        while (p != null) {
            cur.next = p.next;
            cur = cur.next;
//            这里不理解为什么不能跳
            p.next = cur.next;
            p = p.next;
        }
        return result.next;
    }

    public Node copyRandomList(Node head) {
//        使用hash表，key为原节点，value为新节点
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }
//        这时hash集合里存储了链表中的所有节点,包括对应的next与random节点
        p = head;
        while (p != null) {
            Node newNode = map.get(p);
            if (p.next != null) {
                newNode.next = map.get(p.next);
            }
            if (p.random != null) {
                newNode.random = map.get(p.random);
            }
            p = p.next;
        }
//        这时已经将集合里的所有新节点的next与random连接起来了，所以直接返回head的新节点即可
        return map.get(head);
    }
}

