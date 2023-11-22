package month11.day22.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/22 14:05
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

