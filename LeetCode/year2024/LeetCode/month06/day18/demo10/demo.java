package LeetCode.month06.day18.demo10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/18 14:23
 */
public class demo {
    Node head, p;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        middle(root);
        head.left = p;
        p.right = head;
        return head;
    }

    public void middle(Node root) {
        if (root == null) return;
        middle(root.left);
        if (head == null) {
            head = root;
            p = root;
        } else {
            p.right = root;
            root.left = p;
            p = root;
        }
        middle(root.right);
    }
}

