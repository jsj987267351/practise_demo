package LeetCode.month08.day22.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/22 10:10
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

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

