package month08.day11.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/8/11 17:05
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

