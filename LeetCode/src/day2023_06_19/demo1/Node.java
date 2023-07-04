package day2023_06_19.demo1;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/6/19 14:24
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

