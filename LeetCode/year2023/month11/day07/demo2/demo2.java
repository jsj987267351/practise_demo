package month11.day07.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/7 12:01
 */
public class demo2 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
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
        return map.get(head);
    }


    public Node copyRandomList1(Node head) {
        Node p = head;
        while (p != null) {
            Node copy = new Node(p.val);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                Node next = p.next;
                next.random = p.random.next;
            }
            p = p.next.next;
        }

        Node res = new Node(0);
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

