package LeetCode.month08.day22.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/22 10:11
 */
public class demo {
    public Node connect(Node root) {
        help(root, null);
        return root;
    }

    public void help(Node root, Node next) {
        if (root == null) return;
        root.next = next;
        help(root.left, root.right);
        help(root.right, root.next == null ? null : root.next.left);
    }
}

