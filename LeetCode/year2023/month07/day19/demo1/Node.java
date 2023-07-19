package month07.day19.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/19 15:14
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

