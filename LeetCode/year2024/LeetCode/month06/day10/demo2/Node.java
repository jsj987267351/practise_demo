package LeetCode.month06.day10.demo2;/**
* @description TODO
* @author ：大爆炸
* @date 2024/6/10 16:28
* @version 1.0
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

