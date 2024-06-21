package LeetCode.month06.day21.demo3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 9:39
 */
public class demo {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            Node copyNode = new Node(p.val);
            map.put(p, copyNode);
            p = p.next;
        }
        p = head;
        while (p != null){
            Node copyNode = map.get(p);
            if (p.next!= null){
                copyNode.next = map.get(p.next);
            }
            if (p.random!=null){
                copyNode.random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(head);
    }

    public Node copyRandomList1(Node head) {
        Node res = new Node(-1);
        res.next = head;
        Node p = head;
        while (p != null) {
            Node next = new Node(p.val);
            next.next = p.next;
            p.next = next;
            p = next.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                Node next = p.next;
                next.random = p.random.next;
            }
            p = p.next.next;
        }
        Node pre = res;
        p = head;
        while (p != null) {
            pre.next = p.next;
            pre = pre.next;
            p.next = pre.next;
            p = p.next;
        }
        return res.next;
    }
}

