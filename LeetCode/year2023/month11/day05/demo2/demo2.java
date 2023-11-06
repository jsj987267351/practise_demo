package month11.day05.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/5 16:10
 */
public class demo2 {
    public Node connect(Node root) {
        next(root, null);
        return root;
    }

    public void next(Node root, Node next) {
        if (root == null) return;
        root.next = next;
        next(root.left, root.right);
        next(root.right, root.next != null ? root.next.left : null);
    }
}

