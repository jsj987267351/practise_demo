package month07.day15.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/15 19:21
 */
public class demo2 {
    //    具体解释去看6.7 demo1
    public Node copyRandomList1(Node head) {
        Node p = head;
        while (p != null) {
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        p = head;
        while (p != null) {
            Node newNode = p.next;
            if (p.random != null) {
                newNode.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        Node res = new Node(0);
        Node cur = res;
        while (p != null) {
            Node node = p.next;
            cur.next = node;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }
        return res.next;
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }
        p = head;
        while (p != null) {
            Node node = map.get(p);
            if (p.next != null) {
                node.next = map.get(p.next);
            }
            if (p.random != null) {
                node.random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(head);
    }
}

